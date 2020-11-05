package com.codecool.moviesapi.repository;

import com.codecool.moviesapi.model.MoviePersonRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePersonRoleRepository extends CrudRepository<MoviePersonRole, Long> {
}
