package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.CharacterDTO;
import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Quest;
import com.cris.rpgnext.entity.enums.QuestStatus;
import com.cris.rpgnext.repository.CharacterQuestRepository;
import com.cris.rpgnext.service.ICharacterQuestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacterQuestService implements ICharacterQuestService {

  @Autowired
  private CharacterQuestRepository characterQuestRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public CharacterQuestDTO createCharacterQuest(CharacterDTO characterDTO, QuestDTO questDTO) {
    Character character = modelMapper.map(characterDTO, Character.class);
    Quest quest = modelMapper.map(questDTO, Quest.class);

    CharacterQuest characterQuest = CharacterQuest.builder()
            .status(QuestStatus.IN_PROGRESS)
            .startDate(LocalDateTime.now())
            .character(character)
            .quest(quest)
            .build();

    CharacterQuest savedCharacterQuest = characterQuestRepository.save(characterQuest);

    return modelMapper.map(savedCharacterQuest, CharacterQuestDTO.class);
  }

  @Override
  public CharacterQuestDTO getCharacterQuest(Long characterQuestId) {
    CharacterQuest characterQuest = characterQuestRepository
            .findById(characterQuestId)
            .orElseThrow(() -> new RuntimeException("The quest has not started."));

    return modelMapper.map(characterQuest, CharacterQuestDTO.class);
  }

  @Override
  public CharacterQuestDTO updateCharacterQuestStatus(Long characterQuestId, QuestStatus status) {
    CharacterQuest characterQuest = characterQuestRepository
            .findById(characterQuestId)
            .orElseThrow(() -> new RuntimeException("The quest has not started."));

    characterQuest.setStatus(status);
    characterQuestRepository.save(characterQuest);

    return modelMapper.map(characterQuest, CharacterQuestDTO.class);
  }

  @Override
  public List<CharacterQuestDTO> getCharacterQuestByStatus(Long characterQuestId, QuestStatus status) {
    List<CharacterQuest> characterQuests = characterQuestRepository.findByCharacterIdAndStatus(characterQuestId, status);
    return characterQuests.stream()
            .map(characterQuest -> modelMapper.map(characterQuest, CharacterQuestDTO.class))
            .collect(Collectors.toList());
  }
}
