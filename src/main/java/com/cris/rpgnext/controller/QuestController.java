package com.cris.rpgnext.controller;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.service.ICharacterQuestService;
import com.cris.rpgnext.service.Impl.CharacterQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {
  @Autowired
  ICharacterQuestService characterQuestService = new CharacterQuestService();

  @PostMapping("/start")
  public ResponseEntity<CharacterQuestDTO> startQuest(@RequestParam Long characterId, @RequestParam Long questId) {
    return new ResponseEntity<>(characterQuestService.startQuest(characterId, questId), HttpStatus.CREATED);
  }
}
