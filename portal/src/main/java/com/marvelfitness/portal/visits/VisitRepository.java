package com.marvelfitness.portal.visits;

import org.springframework.data.repository.CrudRepository;

/**
 * Visit Repository interface used to access the visit in the database
 */
public interface VisitRepository extends CrudRepository<Visit, Integer> {

}
