package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreId;

    @Column(nullable = false, length = 50)
    private String name;

//    uncomment for bidirectional relation
//    @ManyToMany(mappedBy = "genres")
//    private Set<Movie> movies;

    public Genre(long genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public Genre() {
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
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
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                '}';
    }
}
