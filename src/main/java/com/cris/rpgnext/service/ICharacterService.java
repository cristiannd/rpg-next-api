package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.exception.IncorrectStatusException;
import com.cris.rpgnext.exception.StartQuestException;

public interface ICharacterService {
    void getExperience(Long characterId, Integer minExperience, Integer maxExperience);
    CharacterQuestDTO startQuest(Long characterId, Long questId) throws StartQuestException;
    CharacterQuestDTO completeQuest(Long characterQuestId) throws IncorrectStatusException;
    CharacterQuestDTO cancelQuest(Long characterQuestId) throws IncorrectStatusException;
}
