package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country> {

    @Autowired
    CountryService(CrudRepository<Country, Long> repository) {
        super(repository);
    }
}
