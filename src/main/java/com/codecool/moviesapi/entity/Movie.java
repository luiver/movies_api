package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;

    @Column(nullable = false, length = 50)
    private String title;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "movie_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id",
                    referencedColumnName = "genre_id"
            )
    )
    private Set<Genre> genres;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false, length = 100)
    private String description;


    public Movie(long movie_id, String title, int year, String description) {
        this.movie_id = movie_id;
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public Movie() {
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
