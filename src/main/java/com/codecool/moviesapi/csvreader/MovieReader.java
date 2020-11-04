package com.codecool.moviesapi.csvreader;

import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Movie;
import com.codecool.moviesapi.entity.Person;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MovieReader extends CsvReader {
    GenericService<Movie> movieService;
    GenericService<Person> personService;
    GenericService<Country> countryService;

    @Autowired
    public MovieReader(GenericService<Person> personService, GenericService<Country> countryService, GenericService<Movie> movieService) {
        this.personService = personService;
        this.countryService = countryService;
        this.movieService = movieService;
    }

    @Override
    protected void makeImports() throws IOException {
        String line;
        String[] elements;
        Movie movie;
        while ((line = reader.readLine()) != null) {
            elements = line.split(",");
            movie = new Movie(elements[0], Integer.parseInt(elements[1]), elements[2]);
            movieService.insert(movie);
        }
    }
}
