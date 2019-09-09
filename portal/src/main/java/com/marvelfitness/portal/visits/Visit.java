package com.marvelfitness.portal.visits;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Visit class to hold information on all Visits in the system
 */
@Entity
public class Visit {

    @Id
    @SequenceGenerator(name = "visit_id_sequence", sequenceName = "visit_id_sequence", initialValue = 1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="visit_id_sequence")
    private int visit_id;
    private int customer_id;
    private Timestamp timestamp;

    /**
     * Default Constructor for a Visit object
     */
    public Visit() {

    }

    /**
     * Constructor to build a new Visit object with all parameters
     * @param visit_id id of Visit
     * @param customer_id id of Customer associated with the Visit
     * @param timestamp time of the Visit
     */
    public Visit(int visit_id, int customer_id, Timestamp timestamp) {
        this.visit_id = visit_id;
        this.customer_id = customer_id;
        this.timestamp = timestamp;
    }

    /**
     * Gets Visit id
     * @return Visit id
     */
    public int getVisit_id() {
        return visit_id;
    }

    /**
     * Sets Visit id
     * @param visit_id visit id
     */
    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    /**
     * Gets Customer id
     * @return customer id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * Sets Customer id
     * @param customer_id customer id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * Gets Timestamp
     * @return Timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets Timestamp
     * @param timestamp Timestamp
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
