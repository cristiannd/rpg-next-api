package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.CharacterDTO;
import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.Level;
import com.cris.rpgnext.repository.CharacterRepository;
import com.cris.rpgnext.service.ICharacterQuestService;
import com.cris.rpgnext.service.ICharacterService;
import com.cris.rpgnext.service.ILevelService;
import com.cris.rpgnext.service.IQuestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterService implements ICharacterService {

  @Autowired
  private CharacterRepository characterRepository;
  @Autowired
  private ILevelService levelService;
  @Autowired
  private IQuestService questService;
  @Autowired
  private ICharacterQuestService characterQuestService;
  @Autowired
  private ModelMapper modelMapper;

  private Character getCharacter(Long characterId) {
    return characterRepository
            .findById(characterId)
            .orElseThrow(() -> new RuntimeException("The founded character is not exist."));
  }

  @Override
  public void getExperience(Long characterId, Integer experience) {
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

  @Override
  public CharacterQuestDTO startQuest(Long characterId, Long questId) {
    Character character = getCharacter(characterId);
    CharacterDTO characterDTO = modelMapper.map(character, CharacterDTO.class);
    QuestDTO quest = questService.getQuest(questId);

    return characterQuestService.createCharacterQuest(characterDTO, quest);
  }

  @Override
  public CharacterQuestDTO completeQuest(Long characterQuestId) {
    characterQuestService.getCharacterQuest(characterQuestId);

    return null;
  }
}


