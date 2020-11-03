package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.Indexable;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class GenericService<T> {
    static Logger log = Logger.getLogger(GenericService.class.getName());
    protected final CrudRepository<T, Long> repository;

    public GenericService(CrudRepository<T, Long> repository) {
        this.repository = repository;

        new FileAppender().setAppend(true);
        BasicConfigurator.configure();
    }

    public Iterable<T> getAll() {
        log.info(getEntityName() + " getAll");
        return repository.findAll();
    }

    private String getEntityName() {
        return this.getClass().getSimpleName().replace("Service", "");
    }

    public Optional<T> getById(Long id) {
        log.info(getEntityName() + " getById " + id);
        return repository.findById(id);
    }

    public void removeById(Long id) {
        log.info(getEntityName() + " removeById " + id);
        repository.deleteById(id);
    }

    public void update(T newObject, Long id) {
        log.info(getEntityName() + " update " + id);
        ((Indexable) newObject).setId(id);
        repository.save(newObject);
    }

    public void insert(T movie) {
        log.info(getEntityName() + " insert");
        repository.save(movie);
    }

    public Long getMaxId() {
        return repository.count();
    }
}
