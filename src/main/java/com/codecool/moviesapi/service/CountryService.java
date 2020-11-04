package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.CountryRepository;
import com.codecool.moviesapi.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country> {

    @Autowired
    public CountryService(CrudRepository<Country, Long> repository) {
        super(repository);
    }

    public Country getByName(String name) {
        return ((CountryRepository) repository).findByName(name);
    }
}
