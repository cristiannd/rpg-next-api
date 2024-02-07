package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rewards")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Reward {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer experience;

  @OneToMany(mappedBy = "reward")
  private List<Item> items = new ArrayList<>();

  @OneToOne(mappedBy = "reward")
  private Quest quest;
}
