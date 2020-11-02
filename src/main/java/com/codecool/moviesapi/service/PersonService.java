package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.PersonRepository;
import com.codecool.moviesapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public Iterable<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(Long id) {
        return personRepository.findByPersonId(id);
    }

    public void removePersonById(Long id) {
        personRepository.deleteByPersonId(id);
    }

    public void updatePerson(Person newPerson, Long id) {
        newPerson.setPersonId(id);
        personRepository.save(newPerson);
    }

    public void insertPerson(Person person) {
        personRepository.save(person);
    }
}
