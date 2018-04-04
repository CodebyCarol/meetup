package com.codecool.meetup.triangels.services;

import com.codecool.meetup.triangels.Utility;
import com.codecool.meetup.triangels.model.Group;
import com.codecool.meetup.triangels.model.User;
import com.codecool.meetup.triangels.repository.GroupRepo;
import com.codecool.meetup.triangels.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Service
public class GroupService {

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Group> getAll() {
        return groupRepo.findAll();
    }

    public Group getGroupById(Long id) {
        return groupRepo.findFirstById(id);
    }

    public void joinToGroup(User user, Long groupId) {
        Group group = getGroupById(groupId);
        group.addUserToGroup(user);
        groupRepo.save(group);
        userRepo.save(user);
    }

    public void createGroup(String name, String descr, User user) {
        Group group= new Group(name, descr, user);
        groupRepo.save(group);
    }

    public boolean canJoin(User user, Group group) {
        return !user.getInGroups().contains(group);
    }


}
