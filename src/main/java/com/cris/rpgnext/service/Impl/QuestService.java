package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.entity.Quest;
import com.cris.rpgnext.repository.QuestRepository;
import com.cris.rpgnext.service.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService implements IQuestService {
  @Autowired
  private QuestRepository questRepository;

  @Override
  public Quest getQuest(Long questId) {
    return questRepository
            .findById(questId)
            .orElseThrow(() -> new RuntimeException("The founded quest is not exist."));
  }
}
