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
    private Integer actualStamina;
    private Integer totalStamina;
    private Integer actualLife;
    private Integer totalLife;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
    @OneToMany(mappedBy = "character")
    private Set<CharacterQuest> quests = new HashSet<>();
}
