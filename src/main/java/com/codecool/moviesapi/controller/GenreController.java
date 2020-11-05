package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.model.Genre;
import com.codecool.moviesapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController extends GenericController<Genre> {

    @Autowired
    GenreController(GenreService service) {
        super(service);
    }
}
