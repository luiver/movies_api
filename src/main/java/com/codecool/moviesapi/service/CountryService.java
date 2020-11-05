package com.codecool.moviesapi.service;

import com.codecool.moviesapi.model.Country;
import com.codecool.moviesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country> {

    @Autowired
    public CountryService(CountryRepository repository) {
        super(repository);
    }

    public Country getByName(String name) {
        return ((CountryRepository) repository).findByNameIgnoreCase(name);
    }
}
