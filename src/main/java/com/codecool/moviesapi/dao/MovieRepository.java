package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie findByMovieId(Long id);

    void deleteByMovieId(Long id);
}
