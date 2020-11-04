package com.codecool.moviesapi.csvreader;

import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Person;
import com.codecool.moviesapi.service.GenericService;
import com.codecool.moviesapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

@Component
public class CsvReader {
    BufferedReader reader;
    PersonService personService;

    @Autowired
    public CsvReader(@Qualifier("personService") GenericService<Person> service, String[] args) {
        setUp(args);
    }

    private void setUp(String[] args) {
        if (!isFilePassed(args)) {
            System.out.println("no file provided");
            return;
        }
        if (!args[0].contains(".csv")) {
            System.out.println("wrong format provided");
            return;
        }
        try {
            reader = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isFilePassed(String[] args) {
        return args.length == 1;
    }

    private void makeImports() throws IOException {
        String line;
        String[] elements;
        Person person;
        while ((line = reader.readLine()) != null) {
            elements = line.split(",");
            person = new Person(elements[0], elements[1], elements[2], Date.valueOf(elements[3]), new Country(elements[4]));
            personService.insert(person);
        }
    }
}

