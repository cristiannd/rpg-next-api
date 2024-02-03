package com.cris.rpgnext.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class QuestDTO {
  private Long id;
  private String name;
  private String description;
  private Integer duration;
  private Integer minExperience;
  private Integer maxExperience;
}
