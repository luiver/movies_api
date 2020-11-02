package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Movie;
import com.codecool.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovieById(@PathVariable Long id) {
        movieService.removeMovieById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateMovie(@RequestBody Movie newMovie, @PathVariable Long id) {
        movieService.updateMovie(newMovie, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertMovie(@RequestBody Movie movie) {
        movieService.insertMovie(movie);
    }
}
