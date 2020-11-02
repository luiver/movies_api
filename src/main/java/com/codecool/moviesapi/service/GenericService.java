package com.codecool.moviesapi.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GenericService<T> {
//    private Repository movieRepository;

    public Iterable<T> getAll();

    public void setRepository(CrudRepository<T, Long> movieRepository);

    public Optional<T> getById(Long id);

    public void removeById(Long id);

    public void update(T newObject, Long id);

    public void insert(T movie);
}
