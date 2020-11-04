package com.codecool.moviesapi.csvreader;

import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Person;
import com.codecool.moviesapi.service.CountryService;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

@Component
public class CsvReader {
    BufferedReader reader;
    GenericService<Person> personService;
    GenericService<Country> countryService;


    @Autowired
    public CsvReader(GenericService<Person> personService, GenericService<Country> countryService) {
        this.personService = personService;
        this.countryService = countryService;
    }

    public void setUp(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            makeImports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makeImports() throws IOException {
        String line;
        String[] elements;
        Person person;
        while ((line = reader.readLine()) != null) {
            elements = line.split(",");
            System.out.println(elements[3]);
            Date date = Date.valueOf(elements[3]);
            Country country = ((CountryService) countryService).getByName(elements[4]);
            person = new Person(elements[0], elements[1], elements[2], date, country);
            personService.insert(person);
        }
        System.out.println("Import successful");
    }
}

