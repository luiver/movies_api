package com.codecool.moviesapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FilterActiveCrudRepository<T> extends CrudRepository<T, Long> {
    Iterable<T> findAllByIsActiveTrue();
}
