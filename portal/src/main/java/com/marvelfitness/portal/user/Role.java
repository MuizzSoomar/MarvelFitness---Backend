package com.marvelfitness.portal.user;

import javax.persistence.*;

/**
 * Role class to hold information for different User Roles. Users can either be customers or employees
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer role_id;

    private RoleName name;

    /**
     * Default constructor of a Role Object
     */
    public Role() {}

    /**
     * Constructor to build a Role instance with the given name
     * @param name name of the new Role
     */
    public Role(RoleName name) {
        this.name = name;
    }

    /**
     * Method to access the Role's ID
     * @return Role ID
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * Method to set the Role's ID
     * @param role_id Role ID
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * Method to access the Role's name
     * @return Role name
     */
    public RoleName getName() {
        return name;
    }

    /**
     * Method to set the Role's name
     * @param name Role name
     */
    public void setName(RoleName name) {
        this.name = name;
    }
}
