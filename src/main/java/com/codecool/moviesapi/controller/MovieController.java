package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Movie;
import com.codecool.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController extends GenericController<Movie> {

    @Autowired
    MovieController(MovieService service) {
        super(service);
    }
}
