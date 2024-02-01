package com.cris.rpgnext.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coins_amount")
public class CoinAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
}
