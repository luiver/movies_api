package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends
        FilterActive<Country>,
        CrudRepository<Country, Long>,
        FindableByName<Country> {

    Iterable<Country> findAllByIsActiveTrue();

    Country findByName(String name);
}
