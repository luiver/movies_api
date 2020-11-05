package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Genre;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController extends GenericController<Genre> {

    @Autowired
    GenreController(@Qualifier("genreService") GenericService<Genre> service) {
        super(service);
    }
}
