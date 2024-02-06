package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "foods")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Food extends Item {

  @Column(nullable = false)
  private Integer staminaRecovery;
}
