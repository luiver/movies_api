package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Person;

import java.util.Collection;

public interface PersonDao {
    Collection<Person> getAllPeople();

    Person getPersonById(Long id);

    void removePersonById(Long id);

    void updatePerson(Person newPerson, Long id);

    void insertPerson(Person person);
}
