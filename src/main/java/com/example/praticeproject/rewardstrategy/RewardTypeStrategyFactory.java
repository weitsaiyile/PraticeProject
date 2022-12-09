package com.example.praticeproject.rewardstrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class RewardTypeStrategyFactory {
    private Map<RewardTypeStratefyEnum,IRewardTypeStrategy> strategies;

    @Autowired
    public RewardTypeStrategyFactory(Set<IRewardTypeStrategy> strategySet){
        createStrategy(strategySet);
    }
    public IRewardTypeStrategy findStrategy(RewardTypeStratefyEnum strategyName){
        return strategies.get(strategyName);
    }
    public void createStrategy(Set<IRewardTypeStrategy> strategySet){
        strategies = new HashMap<>();
        strategySet.forEach(strategy->strategies.put(strategy.getRewardStrategy(),strategy));
    }

}
