package com.marvelfitness.portal.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Reward Service class to perform data access/ modification functionality exposed by the Reward Controller
 */
@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    /**
     * Gets a list of all Rewards from the database
     * @return list of all Rewards
     */
    public List<Reward> getAllRewards() {
        List<Reward> rewards = new ArrayList<>();
        rewardRepository.findAll().forEach(rewards::add);
        return rewards;
    }

    /**
     * Gets an individual Reward from the database with a given id
     * @param reward_id id of Reward to find
     * @return Reward with given id, null if not found
     */
    public Reward getReward(int reward_id) {
        return rewardRepository.findById(reward_id).orElse(null);
    }

    /**
     * Adds a new Reward to the database
     * @param reward new Reward to add
     */
    public void addReward(Reward reward) {
        rewardRepository.save(reward);
    }

    /**
     * Deletes the given Reward from the database
     * @param reward_id id of Reward to delete
     */
    public void deleteReward(int reward_id) {
        rewardRepository.deleteById(reward_id);
    }
}
