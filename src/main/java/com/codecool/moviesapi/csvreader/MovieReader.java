package com.codecool.moviesapi.csvreader;

import com.codecool.moviesapi.entity.*;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MovieReader extends CsvReader {
    GenericService<Movie> movieService;
    GenericService<Person> personService;
    GenericService<Country> countryService;
    GenericService<Genre> genreService;
    GenericService<Role> roleService;

    @Autowired
    public MovieReader(GenericService<Movie> movieService, GenericService<Person> personService, GenericService<Country> countryService,
                       GenericService<Genre> genreService, GenericService<Role> roleService) {
        this.movieService = movieService;
        this.personService = personService;
        this.countryService = countryService;
        this.genreService = genreService;
        this.roleService = roleService;
    }

    @Override
    protected void makeImports() throws IOException {
        String line;
        String[] elements;
        Movie movie;
        while ((line = reader.readLine()) != null) {
            elements = line.split(",");
            movie = new Movie(elements[0], Integer.parseInt(elements[1]), elements[2]);
            String[] genres = elements[3].split(";");
            Country country = countryService.findByName(elements[4]);
            String[] roles = elements[5].split(";");
            movieService.insert(movie);
        }
    }
}
