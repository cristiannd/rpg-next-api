package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterQuestDTO;

public interface ICharacterService {
    void getExperience(Long characterId, Integer experience);
    CharacterQuestDTO startQuest(Long characterId, Long questId);
    CharacterQuestDTO completeQuest(Long characterQuestId);
    CharacterQuestDTO cancelQuest(Long characterQuestId);
}
