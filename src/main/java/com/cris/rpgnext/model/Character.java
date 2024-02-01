package com.cris.rpgnext.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer experience;
    private Integer actualStamina;
    private Integer totalStamina;
    private Integer actualLife;
    private Integer totalLife;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
    @OneToMany(mappedBy = "character")
    private List<Wallet> wallet;
}
