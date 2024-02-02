package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Level;
import com.cris.rpgnext.entity.Quest;
import com.cris.rpgnext.repository.CharacterRepository;
import com.cris.rpgnext.service.ICharacterQuestService;
import com.cris.rpgnext.service.ICharacterService;
import com.cris.rpgnext.service.ILevelService;
import com.cris.rpgnext.service.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService {
  @Autowired
  private CharacterRepository characterRepository;

  @Autowired
  private ILevelService levelService;

  @Autowired
  private IQuestService questService;

  @Autowired
  private ICharacterQuestService characterQuestService;

  @Override
  public Character getCharacter(Long characterId) {
    return characterRepository
            .findById(characterId)
            .orElseThrow(() -> new RuntimeException("The founded character is not exist."));
  }

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

  // TODO: Create a upLevel method to separate the logic of the getExperience()

  @Override
  public CharacterQuestDTO startQuest(Long characterId, Long questId) {
    // Get a character
    Character character = getCharacter(characterId);
    // Get a quest
    Quest quest = questService.getQuest(questId);

    return characterQuestService.createCharacterQuest(character, quest);
  }
}
