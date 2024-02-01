package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.entity.Character;
import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Quest;
import com.cris.rpgnext.entity.enums.QuestStatus;
import com.cris.rpgnext.repository.CharacterQuestRepository;
import com.cris.rpgnext.service.ICharacterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CharacterQuestService implements ICharacterQuest {
  @Autowired
  private CharacterQuestRepository characterQuestRepository;

  @Override
  public void startQuest(Character character, Quest quest) {
    CharacterQuest characterQuest = new CharacterQuest();
    characterQuest.setStatus(QuestStatus.IN_PROGRESS);
    characterQuest.setStartDate(new Date());
    characterQuest.setCharacter(character);
    characterQuest.setQuest(quest);

    characterQuestRepository.save(characterQuest);
  }
}
