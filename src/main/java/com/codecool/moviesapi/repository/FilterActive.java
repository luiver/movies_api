package com.codecool.moviesapi.repository;

public interface FilterActive<T> {
    Iterable<T> findAllByIsActiveTrue();
}
