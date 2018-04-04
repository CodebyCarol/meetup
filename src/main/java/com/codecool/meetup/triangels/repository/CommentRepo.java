package com.codecool.meetup.triangels.repository;

import com.codecool.meetup.triangels.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    Comment findFirstByIdIsNotNullOrderByIdDesc();
}
