package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Quest;
import com.cris.rpgnext.entity.enums.QuestStatus;
import com.cris.rpgnext.repository.CharacterQuestRepository;
import com.cris.rpgnext.service.ICharacterQuestService;
import com.cris.rpgnext.service.ICharacterService;
import com.cris.rpgnext.service.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CharacterQuestService implements ICharacterQuestService {
  @Autowired
  private CharacterQuestRepository characterQuestRepository;

  @Override
  public CharacterQuestDTO createCharacterQuest(Character character, Quest quest) {
    CharacterQuest characterQuest = CharacterQuest.builder()
            .status(QuestStatus.IN_PROGRESS)
            .startDate(new Date())
            .character(character)
            .quest(quest)
            .build();

    CharacterQuest savedCharacterQuest = characterQuestRepository.save(characterQuest);

    QuestDTO savedQuestDTO = QuestDTO.builder()
            .name(savedCharacterQuest.getQuest().getName())
            .description(savedCharacterQuest.getQuest().getDescription())
            .duration(savedCharacterQuest.getQuest().getDuration())
            .build();

    return CharacterQuestDTO.builder()
            .status(savedCharacterQuest.getStatus())
            .startDate(savedCharacterQuest.getStartDate())
            .quest(savedQuestDTO)
            .build();
  }
}
