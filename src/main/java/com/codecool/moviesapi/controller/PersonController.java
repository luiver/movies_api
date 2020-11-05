package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Person;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController extends GenericController<Person> {

    @Autowired
    PersonController(@Qualifier("personService") GenericService<Person> service) {
        super(service);
    }
}
