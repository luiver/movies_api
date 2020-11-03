package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.MoviePersonRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePersonRoleRepository extends CrudRepository<MoviePersonRole, Long> {
}
