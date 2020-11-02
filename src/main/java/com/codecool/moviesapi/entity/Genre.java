package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genre_id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

    public Genre(long genre_id, String name) {
        this.genre_id = genre_id;
        this.name = name;
    }

    public Genre() {
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
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
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                '}';
    }
}
