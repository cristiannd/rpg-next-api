package com.cris.rpgnext.service;

import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.Level;
import com.cris.rpgnext.repository.CharacterRepository;
import com.cris.rpgnext.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService {
  @Autowired
  private CharacterRepository characterRepository;

  @Autowired
  private ILevelService levelService;

  @Override
  public void getExperience(Long characterId, Integer experience) throws Exception {
    Character character = characterRepository
            .findById(characterId)
            .orElseThrow(() -> new RuntimeException("The character does not exist."));

    Integer updatedExp = character.getExperience() + experience;
    Integer expToNextLevel = character.getLevel().getExpNextLevel();

    if (updatedExp < expToNextLevel) {
      character.setExperience(updatedExp);
    } else {
      Level nextLevel = levelService.getNextLevel(character.getLevel());
      character.setLevel(nextLevel);

      Integer exceededExperience = updatedExp - expToNextLevel;
      character.setExperience(exceededExperience);
    }

    characterRepository.save(character);
  }
}
