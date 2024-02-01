package com.cris.rpgnext.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quests")
public class Quest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  private Integer duration;

  private Integer minExperience;

  private Integer maxExperience;

  @ManyToMany(mappedBy = "quest")
  private Set<CharacterQuest> characters = new HashSet<>();
}
