package com.marvelfitness.portal.rewards;

import javax.persistence.*;

/**
 * Reward class to hold information on all Rewards in the system
 */
@Entity
public class Reward {

    @Id
    @SequenceGenerator(name = "reward_id_sequence", sequenceName = "reward_id_sequence", initialValue = 1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reward_id_sequence")
    private int reward_id;
    private int value;
    private String name;
    private String description;

    /**
     * Default Constructor for a Reward object
     */
    public Reward() {

    }

    /**
     * Constructor to build a new Reward object with all parameters
     * @param reward_id id of Reward
     * @param value Reward value
     * @param name Name of Reward
     * @param description Description of Reward
     */
    public Reward(int reward_id, int value, String name, String description) {
        this.reward_id = reward_id;
        this.value = value;
        this.name = name;
        this.description = description;
    }

    /**
     * Method to access Reward ID number
     * @return Reward ID number
     */
    public int getReward_id() {
        return reward_id;
    }

    /**
     * Method to set Reward ID number
     * @param reward_id new Reward ID number
     */
    public void setReward_id(int reward_id) {
        this.reward_id = reward_id;
    }

    /**
     * Method to access Reward value
     * @return Reward value
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to set Reward value
     * @param value new Reward value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Method to access Reward name
     * @return Reward name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set Reward name
     * @param name new Reward name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to access Reward description
     * @return Reward description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set Reward description
     * @param description new Reward description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
