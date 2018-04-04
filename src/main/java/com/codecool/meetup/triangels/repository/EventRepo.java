package com.codecool.meetup.triangels.repository;

import com.codecool.meetup.triangels.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {

    Event findFirstById(long id);
}
