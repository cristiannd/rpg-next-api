package com.cris.rpgnext.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "coin_types")
public class CoinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "coinType")
    private List<CoinAmount> coinAmounts;

}
