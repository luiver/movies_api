package com.codecool.moviesapi.repository;

import com.codecool.moviesapi.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends FilterActiveCrudRepository<Person> {

    Iterable<Person> findAllByIsActiveTrue();
}
