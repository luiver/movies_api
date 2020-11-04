package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends FilterActive<Country>, CrudRepository<Country, Long> {
    @Override
    Iterable<Country> findAllByIsActiveTrue();

    Country findCountryByName(String name);
}
