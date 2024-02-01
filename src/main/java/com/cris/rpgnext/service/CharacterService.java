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
  private LevelRepository levelRepository;

  @Override
  public void getExperience(Long characterId, Integer experience) throws Exception {
    Character character = characterRepository
            .findById(characterId)
            .orElseThrow(() -> new RuntimeException("The character does not exist."));

    Integer actualExp = character.getExperience();
    Integer updatedExp = actualExp + experience;
    Integer expToNextLevel = character.getLevel().getExpNextLevel();

    if (updatedExp < expToNextLevel) {
      character.setExperience(updatedExp);
    } else {
      Long nextLevelId = character.getLevel().getId() + 1;

      // TODO: What should I do when there are no more levels?
      Level nextLevel = levelRepository
              .findById(nextLevelId)
              .orElseThrow(() -> new IllegalStateException("Next level not found."));

      character.setLevel(nextLevel);
      Integer actualMaxExp = character.getLevel().getExpNextLevel();
      Integer exceededExperience = updatedExp - actualMaxExp;

      character.setExperience(exceededExperience);
    }

    characterRepository.save(character);
  }
}
