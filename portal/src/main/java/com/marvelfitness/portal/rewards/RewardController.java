package com.marvelfitness.portal.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller class for Reward functionality. Exposes endpoints used to access and/or modify Reward data
 */
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class RewardController {
    @Autowired
    private RewardService rewardService;

    /**
     * Endpoint for getting a list of all Rewards in the system
     * @return list of Rewards in the database
     */
    @RequestMapping(method=RequestMethod.GET, value="/rewards")
    public List<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    /**
     * Endpoint for getting a Reward by reward_id
     * @param reward_id id of Reward to find
     * @return Reward that matches the given reward_id
     */
    @RequestMapping(method=RequestMethod.GET, value="/rewards/{reward_id}")
    public Reward getReward(@PathVariable int reward_id) {
        return rewardService.getReward(reward_id);
    }

    /**
     * Endpoint for adding a Reward to the database
     * @param reward new Reward to add
     */
    @RequestMapping(method= RequestMethod.POST, value="/rewards")
    public void addReward(@RequestBody Reward reward) {
        rewardService.addReward(reward);
    }

    /**
     * Endpoint for deleting a Reward with the given id from the database
     * @param reward_id id of Reward to delete
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/rewards/{reward_id}")
    public void deleteReward(@PathVariable int reward_id) {
        rewardService.deleteReward(reward_id);
    }

}
