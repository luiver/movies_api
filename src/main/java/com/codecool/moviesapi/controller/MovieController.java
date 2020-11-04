package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Movie;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController extends GenericController<Movie> {

    @Autowired
    MovieController(@Qualifier("movieService") GenericService<Movie> service) {
        super(service);
    }
}
