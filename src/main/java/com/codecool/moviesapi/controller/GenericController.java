package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Indexable;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<T extends Indexable> {
    private final GenericService<T> service;

    GenericController(GenericService<T> service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<T> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public T getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        service.removeById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody T newObject, @PathVariable Long id) {
        service.update(newObject, id);
    }

    @PostMapping
    public void insert(@RequestBody T entity) {
        service.insert(entity);
    }
}
