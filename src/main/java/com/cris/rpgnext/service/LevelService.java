package com.cris.rpgnext.service;

import com.cris.rpgnext.entity.Level;
import com.cris.rpgnext.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LevelService implements ILevelService {
  @Autowired
  LevelRepository levelRepository;

  @Override
  public Level getNextLevel(Level actualLevel) {
    Long nextLevelId = actualLevel.getId() + 1;

    // TODO: What should I do when there are no more levels?
    return levelRepository
            .findById(nextLevelId)
            .orElseThrow(() -> new IllegalStateException("Next level not found."));

  }
}
