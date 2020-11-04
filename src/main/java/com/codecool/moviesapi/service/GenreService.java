package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.GenreRepository;
import com.codecool.moviesapi.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends GenericService<Genre> {

    @Autowired
    GenreService(CrudRepository<Genre, Long> repository) {
        super(repository);
    }

    public Genre getByName(String name) {
        return ((GenreRepository) repository).findByName(name);
    }

}
