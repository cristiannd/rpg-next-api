package com.cris.rpgnext.service;

import com.cris.rpgnext.entity.Level;

public interface ILevelService {
  Level getNextLevel(Level actualLevel);
}
