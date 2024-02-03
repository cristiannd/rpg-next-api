package com.cris.rpgnext.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LevelDTO {

  private Long id;
  private Integer level;
  private Integer expNextLevel;
}
