package com.example.praticeproject;

import com.example.praticeproject.rewardstrategy.IRewardTypeStrategy;
import com.example.praticeproject.rewardstrategy.RewardTypeStratefyEnum;
import com.example.praticeproject.rewardstrategy.RewardTypeStrategyFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PraticeProjectApplicationTests {
    @Autowired
    RewardTypeStrategyFactory rewardTypeStrategyFactory;
    @Test
    void contextLoads() {
    }
    @Test
    public void test_strategy_coin(){
        String memberId = "JCGGGGG";
        RewardNode rewardNode = new RewardNode();
        rewardNode.setType("Coin");
        rewardNode.setNum("100");
        IRewardTypeStrategy rewardTypeStrategy = rewardTypeStrategyFactory.findStrategy(RewardTypeStratefyEnum.valueOf(rewardNode.getType()));
        MemberInfo memberInfo = getMemberInfo(memberId, rewardNode, rewardTypeStrategy);
        Assertions.assertEquals(100L,memberInfo.getBalance());

    }

    private static MemberInfo getMemberInfo(String memberId, RewardNode rewardNode, IRewardTypeStrategy rewardTypeStrategy) {
        MemberInfo memberInfo =  rewardTypeStrategy.memberTakeReward(rewardNode, memberId);
        return memberInfo;
    }

    //extract method

}
