package com.marvelfitness.portal.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        List<Visit> visits = new ArrayList<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    public List<Visit> getAllVisitsByCustomer(int user_id) {
        List<Visit> visits = getAllVisits();
        visits.removeIf(n -> (n.getCustomer_id() != user_id));
        return visits;
    }

    public Visit getVisit(int visit_id) {
        return visitRepository.findById(visit_id).orElse(null);
    }

    public void addVisit(Visit visit) {
        visitRepository.save(visit);
    }

    public void updateVisit(Visit visit, int visit_id) {
        visitRepository.save(visit);
    }

    public void deleteVisit(int visit_id) {
        visitRepository.deleteById(visit_id);
    }
}
