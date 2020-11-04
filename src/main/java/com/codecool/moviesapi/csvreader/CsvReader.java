package com.codecool.moviesapi.csvreader;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CsvReader {
    File file;

    public CsvReader(String[] args) {
        if (!isFilePassed(args)) {
            System.out.println("no file provided");
            return;
        }
        if (!args[0].contains(".csv")) {
            System.out.println("wrong format provided");
            return;
        }
        file = new File(args[0]);
    }

    private boolean isFilePassed(String[] args) {
        return args.length == 1;
    }

    
}

