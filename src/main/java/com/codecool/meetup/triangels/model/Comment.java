package com.codecool.meetup.triangels.model;

import com.sun.org.glassfish.gmbal.NameValue;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String userName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_FIELD")
    private Date currentTime;
    private long time;
    private String content;
    @ManyToOne
    private Event event;

    public Comment( User user, String content, Event event) {
        this.user = user;
        this.userName = user.getName();
        this.currentTime = new Date();
        this.time = currentTime.getTime();
        this.content = content;
        this.event = event;
    }

    public Comment() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public User getUser() {
        return user;
    }
}
