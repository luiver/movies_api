package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends GenericService<Movie> {

    @Autowired
    MovieService(CrudRepository<Movie, Long> repository) {
        super(repository);
    }
}
