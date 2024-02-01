package com.cris.rpgnext.repository;

import com.cris.rpgnext.entity.CharacterQuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterQuestRepository extends JpaRepository<CharacterQuest, Long> {
}
