package com.marvelfitness.portal.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    private List<Reward> customers = new ArrayList<>(Arrays.asList(
            new Reward(1001, 5, "$5", "password1"),
            new Reward(1002, 10, "$10", "password2"),
            new Reward(1003, 15, "$15", "password3")
    ));

    public List<Reward> getAllRewards() {
        List<Reward> rewards = new ArrayList<>();
        rewardRepository.findAll().forEach(rewards::add);
        return rewards;
    }

    public Reward getReward(int reward_id) {
        return rewardRepository.findById(reward_id).orElse(null);

    }

    public void addReward(Reward reward) {
        rewardRepository.save(reward);
    }

    public void updateReward(Reward reward, int reward_id) {
        rewardRepository.save(reward);
    }

    public void deleteReward(int reward_id) {
        rewardRepository.deleteById(reward_id);
    }
}
