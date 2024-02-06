package com.cris.rpgnext.entity;

import com.cris.rpgnext.entity.enums.QuestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "character_quests")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterQuest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private QuestStatus status;

  private LocalDateTime startDate;

  @ManyToOne
  @JoinColumn(name = "character_id", nullable = false)
  private Character character;

  @ManyToOne
  @JoinColumn(name = "quest_id", nullable = false)
  private Quest quest;
}
