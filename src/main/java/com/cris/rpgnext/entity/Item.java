package com.cris.rpgnext.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer score;
  private String name;
}
