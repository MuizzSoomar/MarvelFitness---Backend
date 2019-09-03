package com.marvelfitness.portal.rewards;

import javax.persistence.*;

@Entity
public class Reward {

    @Id
    @SequenceGenerator(name = "reward_id_sequence", sequenceName = "reward_id_sequence", initialValue = 1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reward_id_sequence")
    private int reward_id;
    private int value;
    private String name;
    private String description;

    public Reward() {

    }

    public Reward(int reward_id, int value, String name, String description) {
        this.reward_id = reward_id;
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public int getReward_id() {
        return reward_id;
    }

    public void setReward_id(int reward_id) {
        this.reward_id = reward_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
