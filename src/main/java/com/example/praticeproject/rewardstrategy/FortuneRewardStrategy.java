package com.example.praticeproject.rewardstrategy;

import com.example.praticeproject.CacheService;
import com.example.praticeproject.MemberInfo;
import com.example.praticeproject.RewardNode;
import com.example.praticeproject.protocol.Buffer;
import com.example.praticeproject.protocol.BufferStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FortuneRewardStrategy implements IRewardTypeStrategy{
    @Autowired
    CacheService cacheService;
    @Override
    public RewardTypeStratefyEnum getRewardStrategy() {
        return RewardTypeStratefyEnum.RICH_Fortune;
    }

    @Override
    public MemberInfo memberTakeReward(RewardNode rewardNode, String memberId) {
        MemberInfo memberInfo = null;
        Buffer buffer = new Buffer();
        buffer.setId(Integer.parseInt(rewardNode.getId()));
        buffer.setCount(Integer.parseInt(rewardNode.getNum()));
        if(cacheService.getMemberInfoMap().containsKey(memberId)){
            memberInfo = cacheService.getMemberInfoMap().get(memberId);
            memberInfo.setBufferStatus(BufferStatus.Fortune.toString());
            memberInfo.setBuffer(buffer);

        }else{
            memberInfo = new MemberInfo();
            memberInfo.setBufferStatus(BufferStatus.Fortune.toString());
            memberInfo.setMemberId(memberId);
            memberInfo.setBuffer(buffer);
        }
        cacheService.getMemberInfoMap().put(memberId,memberInfo);
        return memberInfo;

    }
}
