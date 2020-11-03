package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.exception.NotFoundException;
import com.codecool.moviesapi.entity.Indexable;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

public abstract class GenericController<T extends Indexable> {
    private final GenericService<T> service;

    GenericController(GenericService<T> service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<T> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<T> getById(@PathVariable Long id) {
        Optional<T> optionalT = service.getById(id);
        if (optionalT.isEmpty()) throw new NotFoundException();
        return optionalT;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.removeById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody T newObject, @PathVariable Long id) {
        service.update(newObject, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insert(@RequestBody T entity) {
        service.insert(entity);
    }
}
