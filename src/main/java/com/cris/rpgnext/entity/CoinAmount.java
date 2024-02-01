package com.cris.rpgnext.entity;

import jakarta.persistence.*;

import java.util.List;

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
    @OneToMany(mappedBy = "coinAmount")
    private List<Wallet> wallet;
}
