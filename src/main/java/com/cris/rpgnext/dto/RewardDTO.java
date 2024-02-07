package com.cris.rpgnext.dto;

import com.cris.rpgnext.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RewardDTO {

  private Long id;
  private Integer experience;
  private List<Item> items = new ArrayList<>();
}
