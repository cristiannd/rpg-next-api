package com.cris.rpgnext.dto;

import com.cris.rpgnext.entity.enums.QuestStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterQuestDTO {

  private Long id;
  private QuestStatus status;
  private LocalDateTime startDate;
  private QuestDTO quest;
  private CharacterDTO character;
}
