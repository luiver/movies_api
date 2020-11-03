package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.Indexable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class GenericService<T extends Indexable> {
    private final CrudRepository<T, Long> repository;

    public GenericService(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    public Optional<T> getById(Long id) {
        return repository.findById(id);
    }

    public void removeById(Long id) {
        repository.deleteById(id);
    }

    public void update(T newObject, Long id) {
        newObject.setId(id);
        repository.save(newObject);
    }

    public void insert(T newObject) {
        repository.save(newObject);
    }
}
