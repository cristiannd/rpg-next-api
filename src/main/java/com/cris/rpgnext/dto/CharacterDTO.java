package com.cris.rpgnext.dto;

import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.Level;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class CharacterDTO {

  private Long id;
  private String name;
  private Integer experience;
  private Integer actualStamina;
  private Integer totalStamina;
  private Integer actualLife;
  private Integer totalLife;
  private Level level;
  private Set<CharacterQuest> quests;
}
