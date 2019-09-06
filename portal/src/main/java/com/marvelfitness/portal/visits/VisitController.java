package com.marvelfitness.portal.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class VisitController {
    @Autowired
    private VisitService visitService;

    @RequestMapping(method=RequestMethod.GET, value="/visits")
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @RequestMapping(method=RequestMethod.GET, value="/visits/customer/{user_id}")
    public List<Visit> getAllVisitsByCustomer(@PathVariable int user_id) {
        return visitService.getAllVisitsByCustomer(user_id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/customers/visits/{user_id}")
    public ResponseEntity checkIn(@PathVariable int user_id) {
        return visitService.checkIn(user_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/visits/{visit_id}")
    public Visit getVisit(@PathVariable int visit_id) {
        return visitService.getVisit(visit_id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/visits")
    public void addVisit(@RequestBody Visit visit) {
        visitService.addVisit(visit);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/visits/{visit_id}")
    public void deleteVisit(@PathVariable int visit_id) {
        visitService.deleteVisit(visit_id);
    }

}
