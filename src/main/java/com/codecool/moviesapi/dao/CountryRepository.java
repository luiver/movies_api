package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
