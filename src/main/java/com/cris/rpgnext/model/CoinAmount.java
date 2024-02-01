package com.cris.rpgnext.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coin_amount")
public class CoinAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "coin_type_id")
    private CoinType coinType;
}
