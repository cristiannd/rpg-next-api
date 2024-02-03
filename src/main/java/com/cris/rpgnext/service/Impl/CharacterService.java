package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.CharacterDTO;
import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Level;
import com.cris.rpgnext.entity.enums.QuestStatus;
import com.cris.rpgnext.exception.IncorrectStatusException;
import com.cris.rpgnext.exception.StartQuestException;
import com.cris.rpgnext.repository.CharacterRepository;
import com.cris.rpgnext.service.ICharacterQuestService;
import com.cris.rpgnext.service.ICharacterService;
import com.cris.rpgnext.service.ILevelService;
import com.cris.rpgnext.service.IQuestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
  public void getExperience(Long characterId, Integer minExperience, Integer maxExperience) {
    Character character = characterRepository
            .findById(characterId)
            .orElseThrow(() -> new RuntimeException("The character does not exist."));

    // Get a random experience value from the quest's minimum and maximum experience.
    Random random = new Random();
    int experience = random.nextInt(maxExperience - minExperience + 1) + minExperience;

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
  public CharacterQuestDTO startQuest(Long characterId, Long questId) throws StartQuestException {
    List<CharacterQuestDTO> characterQuests = characterQuestService.getCharacterQuestByStatus(characterId, QuestStatus.IN_PROGRESS);
    if(!characterQuests.isEmpty()) throw new StartQuestException("You can only have one quest in progress at a time.");

    Character character = getCharacter(characterId);
    CharacterDTO characterDTO = modelMapper.map(character, CharacterDTO.class);
    QuestDTO quest = questService.getQuest(questId);

    return characterQuestService.createCharacterQuest(characterDTO, quest);
  }

  @Override
  public CharacterQuestDTO completeQuest(Long characterQuestId) throws IncorrectStatusException {
    CharacterQuestDTO characterQuestDTO = characterQuestService.getCharacterQuest(characterQuestId);

    if(characterQuestDTO.getStatus() != QuestStatus.IN_PROGRESS) throw new IncorrectStatusException("Only quests in progress can be completed.");

    LocalDateTime startDate = characterQuestDTO.getStartDate();
    LocalDateTime actualDate = LocalDateTime.now();
    Duration duration = Duration.between(startDate, actualDate);

    int questDuration = characterQuestDTO.getQuest().getDuration();
    long timeInQuest = duration.getSeconds();

    if(timeInQuest < questDuration) throw new IncorrectStatusException("The quest has not been completed. " + (questDuration - timeInQuest) + " seconds left");

    getExperience(
            characterQuestDTO.getCharacter().getId(),
            characterQuestDTO.getQuest().getMinExperience(),
            characterQuestDTO.getQuest().getMaxExperience());

    return characterQuestService.updateCharacterQuestStatus(characterQuestId, QuestStatus.COMPLETED);
  }

  @Override
  public CharacterQuestDTO cancelQuest(Long characterQuestId) throws IncorrectStatusException {
    CharacterQuestDTO characterQuestDTO = characterQuestService.getCharacterQuest(characterQuestId);

    if(characterQuestDTO.getStatus() != QuestStatus.IN_PROGRESS) throw new IncorrectStatusException("Only quests in progress can be cancelled.");

    return characterQuestService.updateCharacterQuestStatus(characterQuestId, QuestStatus.CANCELED);
  }
}


