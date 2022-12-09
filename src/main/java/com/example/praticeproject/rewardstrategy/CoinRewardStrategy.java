package com.example.praticeproject.rewardstrategy;

import com.example.praticeproject.CacheService;
import com.example.praticeproject.MemberInfo;
import com.example.praticeproject.RewardNode;
import com.example.praticeproject.protocol.BufferStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinRewardStrategy implements IRewardTypeStrategy{
    @Autowired
    CacheService cacheService;
    @Override
    public RewardTypeStratefyEnum getRewardStrategy() {
        return RewardTypeStratefyEnum.Coin;
    }

    @Override
    public MemberInfo memberTakeReward(RewardNode rewardNode, String memberId) {
        try {
            MemberInfo memberInfoData = null;
            if(cacheService.getMemberInfoMap().containsKey(memberId)){
                Long coinIncrease = Long.parseLong(rewardNode.getNum());
                memberInfoData = cacheService.getMemberInfoMap().get(memberId);
                Long beforeBalance = memberInfoData.getBalance();
                Long afterBalance = beforeBalance+coinIncrease;
                memberInfoData.setBalance(afterBalance);
            }else{
                Long coinIncrease = Long.parseLong(rewardNode.getNum());
                memberInfoData = new MemberInfo();
                memberInfoData.setMemberId(memberId);
                memberInfoData.setBalance(coinIncrease);
            }
            cacheService.getMemberInfoMap().put(memberId,memberInfoData);
            return memberInfoData;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
