package com.cris.rpgnext.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum QuestStatus {

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  IN_PROGRESS,
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  CANCELED,
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  COMPLETED
}
