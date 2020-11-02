package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    @Column(nullable = false, length = 50)
    private String title;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "movieId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id",
                    referencedColumnName = "genreId"
            )
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "movies_countries",
            joinColumns = @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "movieId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "country_id",
                    referencedColumnName = "countryId"
            )
    )
    private Set<Country> countries;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false, length = 100)
    private String description;

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
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

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Movie() {
    }

    public Movie(long movieId, String title, int year, String description) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.description = description;
    }
}
