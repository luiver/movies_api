package com.codecool.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Validable {
    @JsonIgnore
    boolean isValid();
}
