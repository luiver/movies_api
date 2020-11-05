package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends
        FilterActive<Genre>,
        CrudRepository<Genre, Long>,
        FindableByName<Genre> {

    Iterable<Genre> findAllByIsActiveTrue();

    Genre findByNameIgnoreCase(String name);
}
