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

    /**
     * Gets a list of all Visits from the database
     * @return list of all Visits
     */
    public List<Visit> getAllVisits() {
        List<Visit> visits = new ArrayList<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    /**
     * Gets a list of all Visits by the given customer from the database
     * @param user_id id of customer searching
     * @return list of all Visits that match the input user id
     */
    public List<Visit> getAllVisitsByCustomer(int user_id) {
        List<Visit> visits = getAllVisits();
        visits.removeIf(n -> (n.getCustomer_id() != user_id));
        return visits;
    }

    /**
     * Updates all User rewards balances at the end of the
     * month based on their attendance history in the previous month.
     * Scheduled to execute at 3:00 am on the first of every month
     */
    @Scheduled(cron = "0 0 3 1 * *")
    public void addRewardsAtEndOfMonth() {
        List<User> users = userService.getAllCustomers();
        users.forEach(n -> {
            n.setRewards_balance((short) (n.getRewards_balance() + rewardEarned(n.getUser_id())));
        });
    }

    /**
     * Returns the correct amount of reward earned by the given customer in the previous month
     * @param user_id id of Customer who will receive the reward
     * @return the amount of reward earned
     */
    public int rewardEarned(int user_id) {
        int minimum = getMinimumVisitsInAMonth(user_id);
        if (minimum >= 4) {
            return 10;
        } else if (minimum >= 2) {
            return 5;
        }
        return 0;
    }

    /**
     * Calculates the minimum number of visits per week in the previous month by the given customer
     * @param user_id id of Customer
     * @return the minimum number of visits per week
     */
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

    /**
     * Adds a new visit to the database when the given customer checks in to the gym
     * @param user_id id of Customer checking in
     * @return Appropriate ResponseEntity based on validity of user_id (404 if not a valid customer, 200 if valid)
     */
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

    /**
     * Gets an individual Visit from the database with a given id
     * @param visit_id id of Visit to find
     * @return Visit with given id, null if not found
     */
    public Visit getVisit(int visit_id) {
        return visitRepository.findById(visit_id).orElse(null);
    }

    /**
     * Adds a Visit to the database
     * @param visit new Visit to be added
     */
    public void addVisit(Visit visit) {
        visitRepository.save(visit);
    }

    /**
     * Deletes a Visit from the database
     * @param visit_id id of Visit to be deleted
     */
    public void deleteVisit(int visit_id) {
        visitRepository.deleteById(visit_id);
    }
}
