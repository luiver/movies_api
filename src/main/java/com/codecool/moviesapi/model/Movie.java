package com.codecool.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Entity(name = "movies")
public class Movie implements Indexable, Archivable, Validable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "boolean default true")
    @JsonIgnore
    private boolean isActive = true;

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

    @OneToMany(mappedBy = "movie")
    private Set<MoviePersonRole> people;
    @Column(nullable = false)
    private Integer year;
    @Column()
    private String description;

    public Movie() {
    }

    public Movie(Long id, String title, Integer year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public Movie(String title, Integer year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public Set<MoviePersonRole> getPeople() {
        return people;
    }

    public void setPeople(Set<MoviePersonRole> people) {
        this.people = people;
    }

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    @Override
    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                ", countries=" + countries +
                ", people=" + people +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean isValid() {
        return (title != null) && isYearValid(year);
    }

    private boolean isYearValid(Integer year){
        return (1895 < year && year < Year.now().getValue());
    }
}
