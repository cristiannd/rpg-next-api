package com.cris.rpgnext.service;

public interface ICharacterService {
    void getExperience(Long characterId, Integer experience) throws Exception;
}
