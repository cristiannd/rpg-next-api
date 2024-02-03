package com.cris.rpgnext.dto;

import com.cris.rpgnext.entity.enums.QuestStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
public class CharacterQuestDTO {

  private Long id;
  private QuestStatus status;
  private LocalDateTime startDate;
  private QuestDTO quest;
}
