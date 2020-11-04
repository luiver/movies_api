package com.codecool.moviesapi;

import com.codecool.moviesapi.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class MoviesApiApplication {
    static CsvReader csvReader;
    static boolean isRunning;

    @Autowired
    public MoviesApiApplication(CsvReader csvReader) {
        MoviesApiApplication.csvReader = csvReader;
        MoviesApiApplication.isRunning = true;
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviesApiApplication.class, args);
        Scanner scan = new Scanner(System.in);
        String s;
        while (isRunning) {
            s = scan.nextLine();
            if (isImport(s)) {
                csvReader.setUp(getFileName(s));
            }
            if (s.equals("exit")){
                isRunning = false;
            }
        }
    }

    private static String getFileName(String s) {
        return s.split(" ")[1];
    }

    private static boolean isImport(String s) {
        return s.split(" ")[0].equals("import");
    }
}
