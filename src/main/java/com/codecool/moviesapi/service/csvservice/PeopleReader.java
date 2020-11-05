package com.codecool.moviesapi.service.csvservice;

import com.codecool.moviesapi.model.Country;
import com.codecool.moviesapi.model.Person;
import com.codecool.moviesapi.service.CountryService;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;

@Component
public class PeopleReader extends CsvReader {
    GenericService<Person> personService;
    GenericService<Country> countryService;

    @Autowired
    public PeopleReader(GenericService<Person> personService, GenericService<Country> countryService) {
        this.personService = personService;
        this.countryService = countryService;
    }

    @Override
    protected void makeImports() throws IOException {
        String line;
        String[] elements;
        Person person;
        while ((line = reader.readLine()) != null) {
            elements = line.split(",");
            Date date = Date.valueOf(elements[3]);
            Country country = ((CountryService) countryService).getByName(elements[4]);
            person = new Person(elements[0], elements[1], elements[2], date, country);
            personService.insert(person);
        }
    }
}
