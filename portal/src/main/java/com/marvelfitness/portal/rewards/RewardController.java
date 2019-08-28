package com.marvelfitness.portal.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @RequestMapping("/rewards")
    public List<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @RequestMapping("/rewards/{reward_id}")
    public Reward getReward(@PathVariable int reward_id) {
        return rewardService.getReward(reward_id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/rewards")
    public void addReward(@RequestBody Reward reward) {
        rewardService.addReward(reward);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/rewards/{reward_id}")
    public void updateReward(@RequestBody Reward reward, @PathVariable int reward_id) {
        rewardService.updateReward(reward, reward_id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/rewards/{reward_id}")
    public void deleteReward(@PathVariable int reward_id) {
        rewardService.deleteReward(reward_id);
    }

}
