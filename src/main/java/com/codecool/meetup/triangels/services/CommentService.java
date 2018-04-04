package com.codecool.meetup.triangels.services;

import com.codecool.meetup.triangels.model.Comment;
import com.codecool.meetup.triangels.model.Event;
import com.codecool.meetup.triangels.model.User;
import com.codecool.meetup.triangels.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    public Comment getLastComment() {
        return commentRepo.findFirstByIdIsNotNullOrderByIdDesc();
    }

    public void createComment(User user, String content, Event event) {
        Comment comment= new Comment(user, content, event);
        commentRepo.save(comment);
    }
}
