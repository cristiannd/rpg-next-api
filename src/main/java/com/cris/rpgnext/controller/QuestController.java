package com.cris.rpgnext.controller;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.CompletedQuestDTO;
import com.cris.rpgnext.exception.IncorrectStatusException;
import com.cris.rpgnext.exception.StartQuestException;
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
  public ResponseEntity<CharacterQuestDTO> startQuest(@RequestParam Long characterId, @RequestParam Long questId) throws StartQuestException {
    return new ResponseEntity<>(characterService.startQuest(characterId, questId), HttpStatus.CREATED);
  }

  @PostMapping("/complete")
  public ResponseEntity<CompletedQuestDTO> completeQuest(@RequestParam Long characterQuestId) throws Exception {
    return new ResponseEntity<>(characterService.completeQuest(characterQuestId), HttpStatus.OK);
  }

  @PostMapping("/cancel")
  public ResponseEntity<CharacterQuestDTO> cancelQuest(@RequestParam Long characterQuestId) throws IncorrectStatusException {
    return new ResponseEntity<>(characterService.cancelQuest(characterQuestId), HttpStatus.OK);
  }
}
