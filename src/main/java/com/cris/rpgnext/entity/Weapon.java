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
  @Column(nullable = false)
  private Long id;
  @Column(nullable = false)
  private String name;
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
  @ManyToOne
  @JoinColumn(name = "weapon_category_id", nullable = false)
  private WeaponCategory weaponCategory;
}
