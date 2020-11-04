package com.codecool.moviesapi.csvreader;

import com.codecool.moviesapi.entity.*;
import com.codecool.moviesapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class MovieReader extends CsvReader {
    MovieService movieService;
    PersonService personService;
    CountryService countryService;
    GenreService genreService;
    RoleService roleService;

    @Autowired
    public MovieReader(MovieService movieService, PersonService personService, CountryService countryService,
                       GenreService genreService, RoleService roleService) {
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
            String[] countries = elements[4].split(";");
            String[] roles = elements[5].split(";");
            setGenres(genres, movie);
            setCountries(countries, movie);
            setRoles(roles, movie);
            movieService.insert(movie);
        }
    }

    private void setRoles(String[] roles, Movie movie) {
        Set<MoviePersonRole> moviePersonRoleSet = new HashSet<>();
        for (String rolePersonId : roles) {
            String roleString = rolePersonId.split("-")[0];
            Long personId = Long.parseLong(rolePersonId.split("-")[1]);
            Role role = roleService.getByName(roleString);
            Person person = personService.getById(personId);
            MoviePersonRole moviePersonRole = new MoviePersonRole();
            moviePersonRole.setMovie(movie);
            moviePersonRole.setPerson(person);
            moviePersonRole.setRole(role);
        }
        movie.setPeople(moviePersonRoleSet);
    }

    private void setCountries(String[] countries, Movie movie) {
            Set<Country> countrySet = new HashSet<>();
            for (String movieName : countries) {
                Country country = countryService.getByName(movieName);
                countrySet.add(country);
            }
            movie.setCountries(countrySet);
        }

    private void setGenres(String[] genres, Movie movie) {
        Set<Genre> genreSet = new HashSet<>();
        for (String genreName : genres) {
            Genre genre = genreService.getByName(genreName);
            genreSet.add(genre);
        }
        movie.setGenres(genreSet);
    }
}
