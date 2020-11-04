package com.codecool.moviesapi.dao;

public interface FindableByName<T> {

    T findByName(String name);
}
