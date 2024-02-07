package com.cris.rpgnext.service.Impl;

import com.cris.rpgnext.dto.RewardDTO;
import com.cris.rpgnext.entity.Item;
import com.cris.rpgnext.entity.Reward;
import com.cris.rpgnext.repository.RewardRepository;
import com.cris.rpgnext.service.IRewardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RewardService implements IRewardService {

  @Autowired
  private RewardRepository rewardRepository;

  @Autowired
  private ModelMapper modelMapper;

  private Item getAnItem(Item item) {
    Random random = new Random();
    Integer randomNum = random.nextInt(1001);

    return item.getScore() < randomNum ? item : null;
  }

  @Override
  public RewardDTO getRewardById(Long rewardId) throws Exception {
    Reward reward = rewardRepository
            .findById(rewardId)
            .orElseThrow(() -> new Exception("The reward id is not exist."));

    List<Item> itemsEarned = reward
            .getItems()
            .stream()
            .map(this::getAnItem)
            .toList();

    reward.setItems(itemsEarned);

    return modelMapper.map(reward, RewardDTO.class);
  }
}
