package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Person;
import com.codecool.moviesapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/people")
public class PersonController {
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable Long id) {
        personService.removePersonById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person newPerson, @PathVariable Long id) {
        personService.updatePerson(newPerson, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertPerson(@RequestBody Person person) {
        personService.insertPerson(person);
    }
}
