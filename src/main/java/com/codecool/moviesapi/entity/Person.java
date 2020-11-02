package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long personId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @ManyToOne
    @Column(name = "country_id")
    private long countryId;

    @Column
    private String bio;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
}
