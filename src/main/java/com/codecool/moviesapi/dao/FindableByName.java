package com.codecool.moviesapi.dao;

public interface FindableByName<T> {

    T findByNameIgnoreCase(String name);
}
