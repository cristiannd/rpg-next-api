package com.cris.rpgnext.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestDTO {
  private String name;
  private String description;
  private Integer duration;
}
