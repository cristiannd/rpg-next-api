package com.cris.rpgnext.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coin_types")
public class CoinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
