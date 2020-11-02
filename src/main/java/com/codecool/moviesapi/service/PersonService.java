package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.PersonDao;
import com.codecool.moviesapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService {
    private PersonDao personDao;

    public Collection<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }

    public void removePersonById(Long id) {
        personDao.removePersonById(id);
    }

    public void updatePerson(Person newPerson, Long id) {
        personDao.updatePerson(newPerson, id);
    }

    public void insertPerson(Person person) {
        personDao.insertPerson(person);
    }
}
