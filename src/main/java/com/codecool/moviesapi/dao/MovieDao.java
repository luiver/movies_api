package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Movie;

import java.util.Collection;

public interface MovieDao {
    Collection<Movie> getAllMovies();

    Movie getMovieById(Long id);

    void removeMovieById(Long id);

    void updateMovie(Movie newMovie, Long id);

    void insertMovie(Movie movie);
}
