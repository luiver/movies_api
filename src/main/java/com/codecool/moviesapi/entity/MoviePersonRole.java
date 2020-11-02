package com.codecool.moviesapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

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
        Person p = new Person();
        p.setId(person.getId());
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        return p;
    }

    public Role getRole() {
        Role r = new Role();
        r.setName(role.getName());
        return r;
    }
}
