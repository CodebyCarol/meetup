package com.codecool.meetup.triangels.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @ManyToMany
    private List<Interest> interests= new ArrayList<>();
    private String avatar;
    private String intro;
    @ManyToMany(mappedBy = "users")
    @LazyCollection(LazyCollectionOption.FALSE)
    //NOTE: was throwing lazyFetch error, but since multiple bidirectional relations
    // fetchtype.EAGER wasnt working (it uses a big big join query)
    // this solution will fire multiple queries.
    private  List<Event> inEvents = new ArrayList<>();
    @ManyToMany(mappedBy = "users")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Group> inGroups = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();



    public User(String name, String email, String password, String avatar, String intro) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.intro = intro;

    }

    public User() {
    }


    public void addInterestToUser(Interest interest) {
        interests.add(interest);
    }

    public void addEventToUser(Event event) {
        inEvents.add(event);
    }

    public void addGroupToUser(Group group) {
        inGroups.add(group);
    }
    public void addCommentToUser(Comment comment) {
        comments.add(comment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public List<Event> getInEvents() {
        return inEvents;
    }

    public List<Group> getInGroups() {
        return inGroups;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Long getId() {
        return id;
    }
}
