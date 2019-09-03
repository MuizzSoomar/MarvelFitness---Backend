package com.marvelfitness.portal.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {
    @Autowired
    private VisitService visitService;

    @RequestMapping(method=RequestMethod.GET, value="/visits")
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @RequestMapping(method=RequestMethod.GET, value="/visits/{visit_id}")
    public Visit getVisit(@PathVariable int visit_id) {
        return visitService.getVisit(visit_id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/visits")
    public void addVisit(@RequestBody Visit visit) {
        visitService.addVisit(visit);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/visits/{visit_id}")
    public void updateVisit(@RequestBody Visit visit, @PathVariable int visit_id) {
        visitService.updateVisit(visit, visit_id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/visits/{visit_id}")
    public void deleteVisit(@PathVariable int visit_id) {
        visitService.deleteVisit(visit_id);
    }

}
