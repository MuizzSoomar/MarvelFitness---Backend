package com.marvelfitness.portal.rewards;

import org.springframework.data.repository.CrudRepository;

/**
 * Reward Repository interface used to access the reward in the database
 */
public interface RewardRepository extends CrudRepository<Reward, Integer> {

}