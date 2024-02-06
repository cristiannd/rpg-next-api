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

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private Integer duration;

  @Column(nullable = false)
  private Integer minExperience;

  @Column(nullable = false)
  private Integer maxExperience;

  @Column(nullable = false)
  private Integer energyCost;

  @ManyToMany(mappedBy = "quest")
  private Set<CharacterQuest> characters = new HashSet<>();
}
