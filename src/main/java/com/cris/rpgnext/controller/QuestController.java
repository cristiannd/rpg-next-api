package com.cris.rpgnext.controller;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

  @Autowired
  private ICharacterService characterService;

  @PostMapping("/start")
  public ResponseEntity<CharacterQuestDTO> startQuest(@RequestParam Long characterId, @RequestParam Long questId) {
    return new ResponseEntity<>(characterService.startQuest(characterId, questId), HttpStatus.CREATED);
  }

  @PostMapping("/complete")
  public ResponseEntity<CharacterQuestDTO> completeQuest(@RequestParam Long characterQuestId) {
    return new ResponseEntity<>(characterService.completeQuest(characterQuestId), HttpStatus.OK);
  }
}
