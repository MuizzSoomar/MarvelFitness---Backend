package com.marvelfitness.portal.visits;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Visit {

    @Id
    @SequenceGenerator(name = "visit_id_sequence", sequenceName = "visit_id_sequence", initialValue = 1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="visit_id_sequence")
    private int visit_id;
    private int customer_id;
    private Timestamp timestamp;

    public Visit() {

    }

    public Visit(int visit_id, int customer_id, Timestamp timestamp) {
        this.visit_id = visit_id;
        this.customer_id = customer_id;
        this.timestamp = timestamp;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
