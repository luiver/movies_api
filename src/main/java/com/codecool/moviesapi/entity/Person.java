package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long personId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @ManyToOne
    @Column
    private Country country;

    @Column
    private String bio;

    @Column
    private Date dateOfBirth;
}
