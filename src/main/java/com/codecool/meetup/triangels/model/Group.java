package com.codecool.meetup.triangels.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Groups")
public class Group {


    /*TODO Kati:
    able to view list of Groups, and click on the list items
    to see group details, and join to a given group during session
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Group() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @ManyToMany
    private List<Interest> interests = new ArrayList<>();

    @ManyToMany
    private List<Event> events = new ArrayList<>();

    public Group(String name, String description, User user){
        this.name = name;
        this.description = description;
        addUserToGroup(user);
  //    this.admin = nameAdmin();
    }

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addUserToGroup(User user) {
        users.add(user);
        user.addGroupToUser(this);
    }


    public void addInterestToGroup(Interest interest) {
        interests.add(interest);
    }

    public void addEventToGroup(Event event) {
        events.add(event);
    }

    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public List<Event> getEvents() {
        return events;
    }
}
