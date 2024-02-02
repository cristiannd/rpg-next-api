package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.CharacterQuestDTO;
import com.cris.rpgnext.entity.Character;

public interface ICharacterService {
    Character getCharacter(Long characterId);
    void getExperience(Long characterId, Integer experience) throws Exception;
    CharacterQuestDTO startQuest(Long characterId, Long questId);
}
