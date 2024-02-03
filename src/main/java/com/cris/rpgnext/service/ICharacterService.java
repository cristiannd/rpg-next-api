package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.exception.IncorrectStatusException;

public interface ICharacterService {
    void getExperience(Long characterId, Integer experience);
    CharacterQuestDTO startQuest(Long characterId, Long questId);
    CharacterQuestDTO completeQuest(Long characterQuestId) throws IncorrectStatusException;
    CharacterQuestDTO cancelQuest(Long characterQuestId) throws IncorrectStatusException;
}
