package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.FakeMovieDao;
import com.codecool.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieService {
    private FakeMovieDao movieDao;

    public Collection<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Autowired
    public void setMovieDao(FakeMovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public Movie getMovieById(Long id) {
        return movieDao.getMovieById(id);
    }

    public void removeMovieById(Long id) {
        movieDao.removeMovieById(id);
    }

    public void updateMovie(Movie newMovie, Long id) {
        movieDao.updateMovie(newMovie, id);
    }

    public void insertMovie(Movie movie) {
        movieDao.insertMovie(movie);
    }
}
