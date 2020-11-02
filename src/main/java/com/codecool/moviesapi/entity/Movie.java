package com.codecool.moviesapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "movies")
public class Movie implements Indexable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "movies_countries",
            joinColumns = @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "country_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Country> countries;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Movie(Long id, String title, int year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }
}
