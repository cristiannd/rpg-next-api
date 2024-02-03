package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterDTO;
import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;
import com.cris.rpgnext.entity.enums.QuestStatus;

public interface ICharacterQuestService {
  CharacterQuestDTO getCharacterQuest(Long characterQuestId);
  CharacterQuestDTO createCharacterQuest(CharacterDTO characterDTO, QuestDTO questDTO);
  CharacterQuestDTO updateCharacterQuestStatus(Long characterQuestId, QuestStatus status);
}
