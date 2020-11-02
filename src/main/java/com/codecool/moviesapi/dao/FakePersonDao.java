package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakePersonDao")
public class FakePersonDao implements PersonDao {
    private static final Map<Long, Person> people;

    static {
        people = new HashMap<>() {
            {
                put(1L, new Person("Cezary", "Pazura", "bio", Date.valueOf("1962-06-13"),
                        new Country("Poland")));
                put(2L, new Person("Bogusław", "Linda", "bio", Date.valueOf("1952-06-27"),
                        new Country("Poland")));
                put(3L, new Person("Marek", "Kondrat", "bio", Date.valueOf("1950-10-18"),
                        new Country("Poland")));
            }
        };
    }

    @Override
    public Collection<Person> getAllPeople() {
        return people.values();
    }

    @Override
    public Person getPersonById(Long id) {
        return people.get(id);
    }

    @Override
    public void removePersonById(Long id) {
        people.remove(id);
    }

    @Override
    public void updatePerson(Person newPerson, Long id) {
        newPerson.setPersonId(id);
        people.put(id, newPerson);
    }

    @Override
    public void insertPerson(Person person) {
        person.setPersonId(people.size() + 1L);
        people.put(people.size() + 1L, person);
    }
}
