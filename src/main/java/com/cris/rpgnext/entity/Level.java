package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "levels")
@Getter
@Setter
@NoArgsConstructor
public class Level {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer level;
  private Integer expNextLevel;
  @OneToMany(mappedBy = "level")
  private List<Character> characters;
}
