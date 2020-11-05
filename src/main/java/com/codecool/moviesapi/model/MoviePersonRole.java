package com.codecool.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "movies_people_roles")
public class MoviePersonRole implements Indexable, Validable {

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

    public MoviePersonRole(Long id, Movie movie, Person person, Role role) {
        this.id = id;
        this.movie = movie;
        this.person = person;
        this.role = role;
    }

    public MoviePersonRole() {}

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

    @JsonIgnore
    public Integer getMovieYear() {
        return movie.getYear();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void setId(Long id) {
        this.id =id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
