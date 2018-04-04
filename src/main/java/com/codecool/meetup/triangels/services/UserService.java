package com.codecool.meetup.triangels.services;

import com.codecool.meetup.triangels.Utility;
import com.codecool.meetup.triangels.model.User;
import com.codecool.meetup.triangels.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Random;


@Service
public class UserService {

    @Autowired
    private GroupService groupService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Utility utility;


    private String [] avatars ={"alter.jpg", "speaker-1.png", "speaker-2.png", "speaker-3.png",
                                "speaker-4.png", "speaker-5.png", "speaker-6.png"};
    Random random = new Random();


    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getUserByName(String name) {
        return userRepo.findFirstByName(name);
    }

    public User getUserById(Long id) {
        return userRepo.findFirstById(id);
    }

    public boolean checkIfUserNameExists(String name) {
        return getUserByName(name) != null;
    }

    public void createUser(String name, String email, String pw, String avatar, String intro) {

        User user = new User(name, email, pw, avatar, intro);
        userRepo.save(user);
    }

    public List<User> getUsersByGroup(Long groupId) {
        return groupService.getGroupById(groupId).getUsers();
    }

    public List<User> getUsersByEvent(Long eventId) {
        return eventService.getEventById(eventId).getUsers();
    }

    public User getUserPasswordByName(String name) {
        if (checkIfUserNameExists(name)) {
            return getUserByName(name);
        } else {
            return null;
        }
    }

    public boolean ifCreateUser(String name, String email, String password, String intro) {
        if (!checkIfUserNameExists(name)) {
            createUser(
                    name,
                    email,
                    utility.hashPassword(password),
                    avatars[random.nextInt(avatars.length)],
                    intro
            );
            return true;
        }
        return false;
    }

    public boolean canLogIn(String name, String password) {
        return getUserPasswordByName(name) != null &&
                utility.checkPassword(password, getUserPasswordByName(name).getPassword());
    }

    public List getGroupsWhichUserIn(String name) {
        return getUserByName(name).getInGroups();
    }

}
