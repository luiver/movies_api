package com.codecool.moviesapi.repository;

import com.codecool.moviesapi.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends FilterActive<Movie>, CrudRepository<Movie, Long> {

    Iterable<Movie> findAllByIsActiveTrue();
}
