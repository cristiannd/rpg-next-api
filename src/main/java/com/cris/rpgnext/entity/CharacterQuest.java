package com.cris.rpgnext.entity;

import com.cris.rpgnext.entity.enums.QuestStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "character_quests")
@Getter
@Builder
public class CharacterQuest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "character_id")
  private Character character;
  @ManyToOne
  @JoinColumn(name = "quest_id")
  private Quest quest;
  private QuestStatus status;
  private LocalDateTime startDate;
}
