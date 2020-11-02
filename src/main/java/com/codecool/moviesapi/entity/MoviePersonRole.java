package com.codecool.moviesapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "movies_people")
public class MoviePersonRole implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
