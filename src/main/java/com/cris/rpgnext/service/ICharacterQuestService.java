package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.Quest;

public interface ICharacterQuestService {
  CharacterQuestDTO createCharacterQuest(Character character, Quest quest);
}
