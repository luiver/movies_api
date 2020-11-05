package com.codecool.moviesapi.service;

import com.codecool.moviesapi.model.Person;
import com.codecool.moviesapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends GenericService<Person> {

    @Autowired
    public PersonService(PersonRepository repository) {
        super(repository);
    }
}
