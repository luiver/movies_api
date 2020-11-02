package com.codecool.moviesapi.entity;

import javax.persistence.*;

@Entity(name = "countries")
public class Country implements Indexable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

//    uncomment for bidirectional relation
//    @ManyToMany(mappedBy = "countries")
//    private Set<Movie> movies;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
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

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
