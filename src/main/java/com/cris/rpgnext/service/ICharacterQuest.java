package com.cris.rpgnext.service;

import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.Quest;

public interface ICharacterQuest {
  void startQuest(Character character, Quest quest);
}
