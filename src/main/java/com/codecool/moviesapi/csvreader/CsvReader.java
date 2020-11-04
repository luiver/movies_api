package com.codecool.moviesapi.csvreader;

import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Person;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public abstract class CsvReader {
    BufferedReader reader;
    String path = "src/main/resources/csv/";

    public void importFromFile(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(path + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            makeImports();
            System.out.println("Import successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void makeImports() throws IOException ;
}

