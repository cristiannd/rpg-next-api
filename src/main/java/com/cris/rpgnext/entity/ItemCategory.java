package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  @OneToMany(mappedBy = "itemCategory")
  private Set<WeaponCategory> weaponCategories = new HashSet<>();

  @OneToMany(mappedBy = "itemCategory")
  private Set<ArmorCategory> armorCategories = new HashSet<>();
}
