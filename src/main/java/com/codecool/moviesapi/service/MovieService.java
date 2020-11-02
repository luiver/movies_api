package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.MovieRepository;
import com.codecool.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {
    private MovieRepository movieRepository;

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Autowired
    public void setMovieDao(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findByMovieId(id);
    }

    public void removeMovieById(Long id) {
        movieRepository.deleteByMovieId(id);
    }

    public void updateMovie(Movie newMovie, Long id) {
        newMovie.setMovieId(id);
        movieRepository.save(newMovie);
    }

    public void insertMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
