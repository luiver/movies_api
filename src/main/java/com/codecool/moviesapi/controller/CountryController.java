package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Country;
import com.codecool.moviesapi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController extends GenericController<Country> {

    @Autowired
    CountryController(CountryService service) {
        super(service);
    }
}
