package com.codecool.moviesapi.service;

import com.codecool.moviesapi.dao.FilterActive;
import com.codecool.moviesapi.entity.Archivable;
import com.codecool.moviesapi.entity.Indexable;
import com.codecool.moviesapi.exception.NotFoundException;
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
        return ((FilterActive<T>) repository).findAllByIsActiveTrue();
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
        Optional<T> optionalEntity = repository.findById(id);

        optionalEntity.ifPresent(e -> {
            ((Archivable) e).setIsActive(false);
            repository.save(e);
        });
    }

    public void update(T newObject, Long id) {
        log.info(getEntityName() + " update " + id);
        ((Indexable) newObject).setId(id);
        repository.save(newObject);
    }

    public void insert(T newObject) {
        log.info(getEntityName() + " insert");
        repository.save(newObject);
    }

    public Long getMaxId() {
        return repository.count();
    }
}
