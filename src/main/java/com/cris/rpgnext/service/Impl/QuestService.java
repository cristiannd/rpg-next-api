package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.Quest;
import com.cris.rpgnext.repository.QuestRepository;
import com.cris.rpgnext.service.IQuestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestService implements IQuestService {
  @Autowired
  private QuestRepository questRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public QuestDTO getQuest(Long questId) {
    Quest foundedQuest = questRepository
            .findById(questId)
            .orElseThrow(() -> new RuntimeException("The founded quest is not exist."));

    return modelMapper.map(foundedQuest, QuestDTO.class);
  }
}
