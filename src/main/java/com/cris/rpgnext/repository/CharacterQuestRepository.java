package com.cris.rpgnext.repository;

import com.cris.rpgnext.entity.CharacterQuest;
import com.cris.rpgnext.entity.enums.QuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterQuestRepository extends JpaRepository<CharacterQuest, Long> {

  @Query("SELECT cq FROM CharacterQuest cq WHERE cq.character.id = :characterId AND cq.status = :status")
  List<CharacterQuest> findByCharacterIdAndStatus(@Param("characterId") Long characterId, @Param("status") QuestStatus status);
}
