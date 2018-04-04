package com.codecool.meetup.triangels.model;

import javax.persistence.*;


@Entity
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interest;

    public Interest(String interest) {
        this.interest = interest;
    }

    public Interest() {
    }
}
