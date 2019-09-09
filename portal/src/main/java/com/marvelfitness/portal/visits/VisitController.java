package com.marvelfitness.portal.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller class for Visit functionality. Exposes endpoints used to access and/or modify Visit data
 */
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class VisitController {
    @Autowired
    private VisitService visitService;

    /**
     * Endpoint for getting a list of all Visits in the system
     * @return list of Visits in the database
     */
    @RequestMapping(method=RequestMethod.GET, value="/visits")
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    /**
     * Endpoint for getting a list of all Visits by the given customer from the database
     * @param user_id id of customer searching
     * @return list of all Visits that match the input user id
     */
    @RequestMapping(method=RequestMethod.GET, value="/visits/customer/{user_id}")
    public List<Visit> getAllVisitsByCustomer(@PathVariable int user_id) {
        return visitService.getAllVisitsByCustomer(user_id);
    }

    /**
     * Endpoint that adds a new visit to the database when the given customer checks in to the gym
     * @param user_id id of Customer checking in
     * @return Appropriate ResponseEntity based on validity of user_id (404 if not a valid customer, 200 if valid)
     */
    @RequestMapping(method=RequestMethod.POST, value="/customers/visits/{user_id}")
    public ResponseEntity checkIn(@PathVariable int user_id) {
        return visitService.checkIn(user_id);
    }

    /**
     * Endpoint to get an individual Visit from the database with a given id
     * @param visit_id id of Visit to find
     * @return Visit with given id, null if not found
     */
    @RequestMapping(method=RequestMethod.GET, value="/visits/{visit_id}")
    public Visit getVisit(@PathVariable int visit_id) {
        return visitService.getVisit(visit_id);
    }

    /**
     * Endpoint to add a Visit to the database
     * @param visit new Visit to be added
     */
    @RequestMapping(method= RequestMethod.POST, value="/visits")
    public void addVisit(@RequestBody Visit visit) {
        visitService.addVisit(visit);
    }

    /**
     * Endpoint to delete a Visit from the database
     * @param visit_id id of Visit to be deleted
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/visits/{visit_id}")
    public void deleteVisit(@PathVariable int visit_id) {
        visitService.deleteVisit(visit_id);
    }

}
