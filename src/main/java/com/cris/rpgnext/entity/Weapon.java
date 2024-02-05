package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "weapons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weapon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer score;
  private Boolean oneHand;
  private Integer physicalDamage;
  private Integer actualDurability;
  private Integer maxDurability;
}
