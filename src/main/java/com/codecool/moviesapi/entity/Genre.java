package com.codecool.moviesapi.entity;

import javax.persistence.*;

@Entity(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

//    uncomment for bidirectional relation
//    @ManyToMany(mappedBy = "genres")
//    private Set<Movie> movies;

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
