package com.example.praticeproject.rewardstrategy;

import com.example.praticeproject.MemberInfo;
import com.example.praticeproject.RewardNode;

public interface IRewardTypeStrategy {
    RewardTypeStratefyEnum getRewardStrategy();
    MemberInfo memberTakeReward(RewardNode rewardNode , String memberId);
}
