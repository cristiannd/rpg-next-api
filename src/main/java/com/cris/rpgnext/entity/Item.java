package com.cris.rpgnext.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer score;

  @ManyToOne
  @JoinColumn(name = "item_sub_category")
  private ItemSubCategory itemSubCategory;

  @ManyToOne
  @JoinColumn(name = "inventory_id")
  private Inventory inventory;
}
