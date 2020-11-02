package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "movies_people_roles")
public class MoviePersonRole implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public Person getPerson() {
        return person;
    }

    public Role getRole() {
        return role;
    }
}
