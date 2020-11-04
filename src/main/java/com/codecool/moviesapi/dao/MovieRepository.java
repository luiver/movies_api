package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends FilterActive<Movie>, CrudRepository<Movie, Long> {

    Iterable<Movie> findAllByIsActiveTrue();
}
