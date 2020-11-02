package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "people")
public class Person implements Indexable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    private String bio;
    private Date dateOfBirth;

    @ManyToOne
    private Country country;

//    uncomment for bidirectional relation
//    @ManyToMany(mappedBy = "peoples")
//    private Set<Movie> movies;

    public Person(String name, String surname, String bio, Date dateOfBirth, Country country) {
        this.name = name;
        this.surname = surname;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bio='" + bio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country=" + country +
                '}';
    }

//    public Set<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(Set<Movie> movies) {
//        this.movies = movies;
//    }
}
