package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_sub_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemSubCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToOne
  @JoinColumn(name = "item_category_id")
  private ItemCategory itemCategory;

  @OneToMany(mappedBy = "itemSubCategory")
  private List<Item> items = new ArrayList<>();

}
