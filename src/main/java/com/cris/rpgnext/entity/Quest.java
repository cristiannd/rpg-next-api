package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private Integer duration;
  private Integer minExperience;
  private Integer maxExperience;
  private Integer energyCost;
  @ManyToMany(mappedBy = "quest")
  private Set<CharacterQuest> characters = new HashSet<>();
}
