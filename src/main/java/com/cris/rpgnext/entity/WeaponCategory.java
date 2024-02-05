package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "weapon_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeaponCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "weaponCategory")
  private List<Weapon> weapons = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "item_category_id", nullable = false)
  private ItemCategory itemCategory;
}
