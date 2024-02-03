package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterDTO;
import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.QuestDTO;

public interface ICharacterQuestService {
  CharacterQuestDTO getCharacterQuest(Long characterQuestId);
  CharacterQuestDTO createCharacterQuest(CharacterDTO characterDTO, QuestDTO questDTO);
}
