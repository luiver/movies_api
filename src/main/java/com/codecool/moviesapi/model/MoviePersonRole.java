package com.codecool.moviesapi.model;

import javax.persistence.*;

@Entity(name = "movies_people_roles")
public class MoviePersonRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

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

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        Role r = new Role();
        r.setName(role.getName());
        return r;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
