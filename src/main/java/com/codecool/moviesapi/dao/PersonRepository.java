package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends FilterActive<Person>, CrudRepository<Person, Long> {

    Iterable<Person> findAllByIsActiveTrue();
}
