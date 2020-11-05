package com.codecool.moviesapi.repository;

public interface FindableByName<T> {

    T findByNameIgnoreCase(String name);
}
