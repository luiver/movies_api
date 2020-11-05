package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Country;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController extends GenericController<Country> {

    @Autowired
    CountryController(@Qualifier("countryService") GenericService<Country> service) {
        super(service);
    }
}
