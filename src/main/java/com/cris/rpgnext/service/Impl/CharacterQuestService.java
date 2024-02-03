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

    QuestDTO savedQuestDTO = modelMapper.map(savedCharacterQuest.getQuest(), QuestDTO.class);

    return CharacterQuestDTO.builder()
            .id(savedCharacterQuest.getId())
            .status(savedCharacterQuest.getStatus())
            .startDate(savedCharacterQuest.getStartDate())
            .quest(savedQuestDTO)
            .build();
  }

  @Override
  public CharacterQuestDTO getCharacterQuest(Long characterQuestId) {
    CharacterQuest characterQuest = characterQuestRepository
            .findById(characterQuestId)
            .orElseThrow(() -> new RuntimeException("The quest has not started."));

    QuestDTO questDTO = modelMapper.map(characterQuest.getQuest(), QuestDTO.class);

    return CharacterQuestDTO.builder()
            .id(characterQuest.getId())
            .status(characterQuest.getStatus())
            .startDate(characterQuest.getStartDate())
            .quest(questDTO)
            .build();
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
}
