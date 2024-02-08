package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.dto.CompletedQuestDTO;
import com.cris.rpgnext.exception.IncorrectStatusException;
import com.cris.rpgnext.exception.StartQuestException;

public interface ICharacterService {
    CharacterQuestDTO startQuest(Long characterId, Long questId) throws StartQuestException;
    CompletedQuestDTO completeQuest(Long characterQuestId) throws Exception;
    CharacterQuestDTO cancelQuest(Long characterQuestId) throws IncorrectStatusException;
}
