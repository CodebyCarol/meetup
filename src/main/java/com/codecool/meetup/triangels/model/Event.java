package com.codecool.meetup.triangels.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

import static java.util.Calendar.AM;
import static java.util.Calendar.PM;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String time;
    private String place;
    private int maxParticipants;

    @OneToMany
    private List<Interest> interests = new ArrayList<>();

    public void setUsers(User user) {
        users.add(user);
        user.addEventToUser(this);

    }

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users = new ArrayList<>();

    @ManyToOne
    private Group group;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();


    public Event(String name, String description, List<Interest> interest, String place, int maxParticipants) {
        this.name = name;
        this.description = description;
        //this.interest = interest;
        this.place = place;
        this.maxParticipants = maxParticipants;
        this.users = users;
        //this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public Event(String name, String description, String place, String time) {
        this.name = name;
        this.description = description;
        this.place = place;
        this.time = time;

    }

    public Event(String name, String description, String place, List<User> users) {
        this.name = name;
        this.description = description;
        this.place = place;
        this.users = users;
        //this.interest = interest;
    }

    public Event() {
    }

    public void addGroupToEvent(Group group){
        this.group = group;
    }

    public void addInterestToEvent(Interest interest) {
        interests.add(interest);
    }

    public boolean checkEventTime() {
        Calendar eventTime = getCalendarTime(this.time);
        System.out.println(eventTime.getTime());
        System.out.println("Actual time: " + Calendar.getInstance().getTime());
        return Calendar.getInstance().before(eventTime);

    }

    public Calendar getCalendarTime(String time) {
        try {
            Calendar eventTime = Calendar.getInstance();
            eventTime.set(Calendar.MONTH, Integer.parseInt(time.substring(0,2)) - 1);
            eventTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(time.substring(3,5)));
            eventTime.set(Calendar.YEAR, Integer.parseInt(time.substring(6,10)));
            eventTime.set(Calendar.MINUTE, Integer.parseInt(time.substring(time.length()-5, time.length()-3)));
            eventTime.set(Calendar.SECOND, 0);
            eventTime.set(Calendar.MILLISECOND, 0);
            if (time.substring(time.length()-2, time.length()).equals("PM")) {
                eventTime.set(Calendar.HOUR_OF_DAY, PM + (checkTimeStringForHour(time)-1) );
            } else {
                eventTime.set(Calendar.HOUR_OF_DAY, AM + (checkTimeStringForHour(time)-1));

            }
            return eventTime;
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            return null;
        }
    }

    public int checkTimeStringForHour(String time) {
        if (time.substring(time.length()-8, time.length()-6).startsWith(" ")) {
            return Integer.parseInt(time.substring(time.length()-7, time.length()-6));
        }
        return Integer.parseInt(time.substring(time.length()-8, time.length()-6));
    }


    public void addUserToEvent(User user) {
        users.add(user);
        user.addEventToUser(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public List<User> getUsers() {
        return users;
    }

    public Group getGroup() {
        return group;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
