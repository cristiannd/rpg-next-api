package com.cris.rpgnext.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer experience;

    private Integer actualEnergy;

    private Integer totalEnergy;

    private Integer actualLife;

    private Integer totalLife;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "character")
    private Set<CharacterQuest> quests = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
