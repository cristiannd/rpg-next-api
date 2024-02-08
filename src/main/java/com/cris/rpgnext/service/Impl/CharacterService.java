package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.*;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Item;
import com.cris.rpgnext.entity.Level;
import com.cris.rpgnext.entity.enums.QuestStatus;
import com.cris.rpgnext.exception.IncorrectStatusException;
import com.cris.rpgnext.exception.StartQuestException;
import com.cris.rpgnext.repository.CharacterRepository;
import com.cris.rpgnext.service.*;
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

  private IRewardService rewardService;

  @Autowired
  private ModelMapper modelMapper;

  private Character getCharacter(Long characterId) {
    return characterRepository
            .findById(characterId)
            .orElseThrow(() -> new RuntimeException("The founded character is not exist."));
  }

  private Character saveExperienceInCharacter(Character character, Integer experience) {
    Integer updatedExp = character.getExperience() + experience;
    Integer expToNextLevel = character.getLevel().getExpNextLevel();

    if (updatedExp < expToNextLevel) {
      character.setExperience(updatedExp);
    } else {
      // If the experience gained is greater than max experience, the character levels up.
      Level nextLevel = levelService.getNextLevel(character.getLevel());
      character.setLevel(nextLevel);

      Integer exceededExperience = updatedExp - expToNextLevel;
      character.setExperience(exceededExperience);
    }

    return character;
  }

  private Character saveRewardedItemsInCharacterInventory(Character character, List<Item> items) {
    items.forEach(item -> character.getInventory().getItems().add(item));

    return character;
  }

  @Override
  public CharacterQuestDTO startQuest(Long characterId, Long questId) throws StartQuestException {
    List<CharacterQuestDTO> characterQuests = characterQuestService.getCharacterQuestByStatus(characterId, QuestStatus.IN_PROGRESS);
    if(!characterQuests.isEmpty()) throw new StartQuestException("You can only have one quest in progress at a time.");

    QuestDTO questDTO = questService.getQuest(questId);
    Character character = getCharacter(characterId);

    if(questDTO.getEnergyCost() > character.getActualEnergy()) throw new StartQuestException("You don't have enough energy to start this quest.");

    character.setActualEnergy(character.getActualEnergy() - questDTO.getEnergyCost());
    characterRepository.save(character);

    CharacterDTO characterDTO = modelMapper.map(character, CharacterDTO.class);

    return characterQuestService.createCharacterQuest(characterDTO, questDTO);
  }

  @Override
  public CompletedQuestDTO completeQuest(Long characterQuestId) throws Exception {
    CharacterQuestDTO characterQuestDTO = characterQuestService.getCharacterQuest(characterQuestId);

    // The quest must be IN PROGRESS
    if(characterQuestDTO.getStatus() != QuestStatus.IN_PROGRESS) throw new IncorrectStatusException("Only quests in progress can be completed.");

    LocalDateTime questStartDate = characterQuestDTO.getStartDate();
    LocalDateTime currentDate = LocalDateTime.now();
    Duration currentQuestDuration = Duration.between(questStartDate, currentDate);
    long timeOnQuest = currentQuestDuration.getSeconds();
    int questDuration = characterQuestDTO.getQuest().getDuration();

    // Quest time must be complete
    if(timeOnQuest < questDuration) throw new IncorrectStatusException("The quest has not been completed. " + (questDuration - timeOnQuest) + " seconds left.");

    RewardDTO questRewards = rewardService.getRewardById(characterQuestDTO.getQuest().getId());

    Long characterId = characterQuestDTO.getCharacter().getId();
    Character character = getCharacter(characterId);

    // Getting rewards
    Character characterWithExperience = saveExperienceInCharacter(
            character,
            questRewards.getExperience());

    Character characterWithExperienceAndItems = saveRewardedItemsInCharacterInventory(
            characterWithExperience,
            questRewards.getItems());

    // Save updated character
    characterRepository.save(characterWithExperienceAndItems);
    // Save the character's quest as completed
    characterQuestService.updateCharacterQuestStatus(characterQuestId, QuestStatus.COMPLETED);

    CharacterDTO characterDTO = modelMapper.map(character, CharacterDTO.class);
    return CompletedQuestDTO.builder()
            .characterDTO(characterDTO)
            .questStatus(QuestStatus.COMPLETED)
            .build();
  }

  @Override
  public CharacterQuestDTO cancelQuest(Long characterQuestId) throws IncorrectStatusException {
    CharacterQuestDTO characterQuestDTO = characterQuestService.getCharacterQuest(characterQuestId);

    if(characterQuestDTO.getStatus() != QuestStatus.IN_PROGRESS) throw new IncorrectStatusException("Only quests in progress can be cancelled.");

    return characterQuestService.updateCharacterQuestStatus(characterQuestId, QuestStatus.CANCELED);
  }
}
