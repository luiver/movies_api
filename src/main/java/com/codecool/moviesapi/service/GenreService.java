package com.codecool.moviesapi.service;

import com.codecool.moviesapi.model.Genre;
import com.codecool.moviesapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends GenericService<Genre> {

    @Autowired
    GenreService(GenreRepository repository) {
        super(repository);
    }

    public Genre getByName(String name) {
        return ((GenreRepository) repository).findByNameIgnoreCase(name);
    }

}
