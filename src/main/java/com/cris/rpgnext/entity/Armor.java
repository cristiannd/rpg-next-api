package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "armors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Armor extends Item {

  @Column(nullable = false)
  private Integer actualDurability;

  @Column(nullable = false)
  private Integer maxDurability;

  @Column(nullable = false)
  private Integer defense;
}
