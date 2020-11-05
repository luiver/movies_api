package com.codecool.moviesapi.repository;

import com.codecool.moviesapi.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends
        FilterActive<Country>,
        CrudRepository<Country, Long>,
        FindableByName<Country> {

    Iterable<Country> findAllByIsActiveTrue();

    Country findByNameIgnoreCase(String name);
}
