package com.cris.rpgnext.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CharacterDTO {

  private Long id;
  private String name;
  private Integer experience;
  private Integer actualEnergy;
  private Integer totalEnergy;
  private Integer actualLife;
  private Integer totalLife;
  private LevelDTO level;
}
