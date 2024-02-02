package com.cris.rpgnext.dto;

import com.cris.rpgnext.entity.enums.QuestStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class CharacterQuestDTO {
  private QuestStatus status;
  private Date startDate;
  private QuestDTO quest;
}