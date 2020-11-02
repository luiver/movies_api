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
}
