package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.PersonRepository;
import com.codecool.moviesapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService implements GenericService<Person> {
    private CrudRepository<Person, Long> personRepository;

    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @Autowired
    public void setRepository(CrudRepository<Person, Long> personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }

    public void removeById(Long id) {
        personRepository.deleteById(id);
    }

    public void update(Person newPerson, Long id) {
        newPerson.setId(id);
        personRepository.save(newPerson);
    }

    public void insert(Person person) {
        personRepository.save(person);
    }
}
