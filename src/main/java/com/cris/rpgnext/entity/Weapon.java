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
public class Weapon extends Item {

  @Column(nullable = false)
  private Integer score;

  @Column(nullable = false)
  private Boolean oneHand;

  @Column(nullable = false)
  private Integer physicalDamage;

  @Column(nullable = false)
  private Integer actualDurability;

  @Column(nullable = false)
  private Integer maxDurability;
}
