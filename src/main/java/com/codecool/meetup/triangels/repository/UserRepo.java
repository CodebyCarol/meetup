package com.codecool.meetup.triangels.repository;

import com.codecool.meetup.triangels.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo  extends JpaRepository<User, Long> {

    User findFirstByName(String name);

    User findFirstById(Long id);

}
