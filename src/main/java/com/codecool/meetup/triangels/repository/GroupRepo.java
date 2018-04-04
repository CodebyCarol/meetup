package com.codecool.meetup.triangels.repository;

import com.codecool.meetup.triangels.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group, Long> {

    Group findFirstById(Long id);
}
