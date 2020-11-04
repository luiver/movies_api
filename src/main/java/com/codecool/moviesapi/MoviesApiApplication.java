package com.codecool.moviesapi;

import com.codecool.moviesapi.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
                csvReader.importFromFile(getFileName(s));
            }
            if (s.equals("exit")){
                isRunning = false;
            }
        }
        System.out.println("Finished importing");
    }

    private static String getFileName(String s) {
        return s.split(" ")[1];
    }

    private static boolean isImport(String s) {
        return s.split(" ")[0].equals("import");
    }
}
