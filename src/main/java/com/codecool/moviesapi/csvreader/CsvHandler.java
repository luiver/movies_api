package com.codecool.moviesapi.csvreader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvHandler {
    BufferedReader bufferedReader;
    String path = "src/main/resources/csv/";
    CsvReader csvReader;
    ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public void importFromFile(String entity, String fileName) {
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            setCsvReader(entity);
            csvReader.setBufferedReader(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            csvReader.makeImports();
            System.out.println("Import successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setCsvReader(String entity) {
        switch (entity) {
            case "people":
                csvReader = (CsvReader) context.getBean("peopleReader");
                break;
            case "movies":
                csvReader = (CsvReader) context.getBean("movieReader");
        }
    }
}
