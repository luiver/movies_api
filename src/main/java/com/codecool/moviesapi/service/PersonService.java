package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends GenericService<Person> {

    @Autowired
    public PersonService(CrudRepository<Person, Long> repository) {
        super(repository);
    }
}
