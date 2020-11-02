package com.codecool.moviesapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "movies_people_roles")
public class MoviePersonRole implements Serializable {
    @Id
    @ManyToOne
    private Movie movie;

    @Id
    @ManyToOne
    private Person person;

    @Id
    @ManyToOne
    private Role role;
}
