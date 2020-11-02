package com.codecool.moviesapi;

import com.codecool.moviesapi.dao.CountryRepository;
import com.codecool.moviesapi.dao.PersonRepository;
import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoviesapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesapiApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(PersonRepository personRepository, CountryRepository countryRepository) {
        return (args -> {
            Country country = populateCountries(countryRepository);
            populatePeople(personRepository, country);
        });
    }

    private void populatePeople(PersonRepository personRepository, Country country) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Cezary", "Pazura", "bio", Date.valueOf("1962-06-13"), country));
        people.add(new Person("Bogusław", "Linda", "bio", Date.valueOf("1952-06-27"), country));
        people.add(new Person("Marek", "Kondrat", "bio", Date.valueOf("1950-10-18"), country));
        personRepository.saveAll(people);
    }

    private Country populateCountries(CountryRepository countryRepository) {
        return countryRepository.save(new Country("Poland"));
    }
}
