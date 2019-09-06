package com.marvelfitness.portal.visits;

import com.marvelfitness.portal.user.User;
import com.marvelfitness.portal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private UserService userService;

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

    public int getMinimumVisitsInAMonth(int user_id) {
        List<Visit> visits = getAllVisitsByCustomer(user_id);
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.add(Calendar.WEEK_OF_YEAR, -2);
        cal1.set(Calendar.DAY_OF_MONTH, cal1.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal2.add(Calendar.WEEK_OF_YEAR, -2);
        cal2.set(Calendar.DAY_OF_MONTH, 7);
        AtomicInteger weekTotal = new AtomicInteger(0);
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            weekTotal.set(0);
            visits.forEach(n -> {
                if (n.getTimestamp().after(new Timestamp(cal1.getTimeInMillis()))
                        && n.getTimestamp().before(new Timestamp(cal2.getTimeInMillis()))) {

                    weekTotal.getAndIncrement();
                }
            });
            minimum = Math.min(weekTotal.get(), minimum);
            cal1.add(Calendar.WEEK_OF_YEAR, 1);
            if (i < 3) {
                cal2.add(Calendar.WEEK_OF_YEAR, 1);
            } else {
                cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
        }
        return minimum;
    }

    public int rewardEarned(int user_id) {
        int minimum = getMinimumVisitsInAMonth(user_id);
        if (minimum >= 4) {
            return 10;
        } else if (minimum >= 2) {
            return 5;
        }
        return 0;
    }

    @Scheduled(cron = "0 0 3 1 * *")
    public void addRewardsAtEndOfMonth() {
        List<User> users = userService.getAllCustomers();
        users.forEach(n -> {
            n.setRewards_balance((short) (n.getRewards_balance() + rewardEarned(n.getUser_id())));
        });
    }

    public ResponseEntity checkIn(int user_id) {
        if (userService.getCustomerById(user_id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Visit visit = new Visit();
        visit.setTimestamp(new Timestamp(System.currentTimeMillis()));
        visit.setCustomer_id(user_id);
        visitRepository.save((visit));
        return new ResponseEntity(HttpStatus.OK);
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
