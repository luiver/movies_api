package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("movieDao")
public class FakeMovieDao implements MovieDao {

    @Override
    public Collection<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(Long id) {
        return null;
    }

    @Override
    public void removeMovieById(Long id) {

    }

    @Override
    public void updateMovie(Movie newMovie, Long id) {

    }

    @Override
    public void insertMovie(Movie movie) {

    }
}
