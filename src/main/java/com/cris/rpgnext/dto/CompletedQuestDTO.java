package com.cris.rpgnext.dto;

import com.cris.rpgnext.entity.enums.QuestStatus;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompletedQuestDTO {

  private QuestStatus questStatus;
  private CharacterDTO characterDTO;

}
