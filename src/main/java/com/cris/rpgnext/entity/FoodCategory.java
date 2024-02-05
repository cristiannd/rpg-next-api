package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "item_category_id")
  private ItemCategory itemCategory;

  @OneToMany(mappedBy = "foodCategory")
  private List<Food> foods = new ArrayList<>();
}
