package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService implements GenericService<Movie> {
    private CrudRepository<Movie, Long> movieRepository;

    public Iterable<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Autowired
    public void setRepository(CrudRepository<Movie, Long> movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }

    public void removeById(Long id) {
        movieRepository.deleteById(id);
    }

    public void update(Movie newMovie, Long id) {
        newMovie.setId(id);
        movieRepository.save(newMovie);
    }

    public void insert(Movie movie) {
        movieRepository.save(movie);
    }
}
