package com.codecool.moviesapi.csvreader;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class CsvReader {
    protected BufferedReader reader;

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.reader = bufferedReader;
    }

    abstract void makeImports() throws IOException;
}