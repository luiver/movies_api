package com.codecool.moviesapi.dao;

public interface FilterActive<T> {
    Iterable<T> findAllByIsActiveTrue();
}
