package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Person;
import com.codecool.moviesapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController extends GenericController<Person> {

    @Autowired
    PersonController(PersonService service) {
        super(service);
    }
}
