package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.QuestDTO;

public interface IQuestService {
  QuestDTO getQuest(Long questId);
}
