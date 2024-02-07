package com.cris.rpgnext.service;

import com.cris.rpgnext.dto.RewardDTO;

public interface IRewardService {
  RewardDTO getRewardById(Long rewardId) throws Exception;
}
