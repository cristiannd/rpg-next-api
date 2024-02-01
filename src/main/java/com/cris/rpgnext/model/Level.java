package com.cris.rpgnext.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer level;
    private Integer expNextLevel;
    @OneToMany(mappedBy = "level")
    private List<Character> characters;
}
