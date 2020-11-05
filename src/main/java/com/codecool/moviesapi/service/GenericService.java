package com.codecool.moviesapi.service;

import com.codecool.moviesapi.exception.NotFoundException;
import com.codecool.moviesapi.model.Archivable;
import com.codecool.moviesapi.model.Indexable;
import com.codecool.moviesapi.repository.FilterActiveCrudRepository;
import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class GenericService<T> {
    static Logger log = Logger.getLogger(GenericService.class.getName());
    protected final CrudRepository<T, Long> repository;

    public GenericService(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Iterable<T> getAll() {
        log.info(getEntityName() + " getAll");
        return ((FilterActiveCrudRepository<T>) repository).findAllByIsActiveTrue();
    }

    private String getEntityName() {
        return this.getClass().getSimpleName().replace("Service", "");
    }

    public T getById(Long id) {
        Optional<T> optional = repository.findById(id);
        log.info(getEntityName() + " getById " + id);
        if (optional.isPresent() && ((Archivable) optional.get()).getIsActive()) return optional.get();
        throw new NotFoundException();
    }

    public void removeById(Long id) {
        log.info(getEntityName() + " removeById " + id);
        T t = getById(id);

        ((Archivable) t).setIsActive(false);
        repository.save(t);
    }

    public void update(T newObject, Long id) {
        log.info(getEntityName() + " update " + id);
        if (!repository.existsById(id)) throw new NotFoundException();

        ((Indexable) newObject).setId(id);
        repository.save(newObject);
    }

    public void insert(T object) {
        log.info(getEntityName() + " insert " + "object data: " + object.toString());
        repository.save(object);
    }

    public Long getMaxId() {
        return repository.count();
    }
}
