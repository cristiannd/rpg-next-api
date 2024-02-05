package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "armors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Armor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private Integer score;

  @Column(nullable = false)
  private Integer actualDurability;

  @Column(nullable = false)
  private Integer maxDurability;

  @Column(nullable = false)
  private Integer defense;
}
