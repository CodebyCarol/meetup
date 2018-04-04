package com.codecool.meetup.triangels.services;

import com.codecool.meetup.triangels.Utility;
import com.codecool.meetup.triangels.model.Interest;
import com.codecool.meetup.triangels.repository.InterestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class InterestService {

    @Autowired
    private InterestRepo interestRepo;

    public List<Interest> getAll() {
    return interestRepo.findAll();
}

    public Interest getInterestById(Long id) {
        return interestRepo.findFirstById(id);
    }

    public void createInterest(String name) {
        Interest interest= new Interest(name);
        interestRepo.save(interest);
    }

    public List<Interest> getInterestsByEvent(int eventId) {
        //todo
//        TypedQuery<Interest> q2 =
//                em.createQuery("SELECT c FROM Interest join event_interest on Interest.id = interest_id group by Interest.id, event_interest.interest_id, event_interest.event_id having event_id = :id;", Interest.class);
//        List<Interest> result = q2.setParameter("id", eventId).getResultList();
        return null;
    }

}
