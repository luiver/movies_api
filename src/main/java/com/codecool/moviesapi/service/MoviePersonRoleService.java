package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.MoviePersonRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MoviePersonRoleService extends GenericService<MoviePersonRole> {

    @Autowired
    MoviePersonRoleService(CrudRepository<MoviePersonRole, Long> repository) {
        super(repository);
    }

    @Override
    public void update(MoviePersonRole newObject, Long id) {
        repository.save(newObject); // TODO do something with this
    }
}
