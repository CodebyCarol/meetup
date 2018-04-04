package com.codecool.meetup.triangels.repository;

import com.codecool.meetup.triangels.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepo extends JpaRepository<Interest, Long>{

    Interest findFirstById(Long id);
}
