package com.codecool.moviesapi;

import com.codecool.moviesapi.csvreader.CsvHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MoviesApiApplication {
    static CsvHandler csvHandler;
    static boolean isRunning;

    @Autowired
    public MoviesApiApplication(CsvHandler csvHandler) {
        MoviesApiApplication.csvHandler = csvHandler;
        MoviesApiApplication.isRunning = true;
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviesApiApplication.class, args);
        Scanner scan = new Scanner(System.in);
        String s;
        while (isRunning) {
            s = scan.nextLine();
            if (isImport(s) && areThreeArgs(s)) {
                String[] arguments = s.split(" ");
                String entity = arguments[1];
                String fileName = arguments[2];
                csvHandler.importFromFile(entity, fileName);
            }
            if (s.equals("exit")) {
                isRunning = false;
            }
        }
        System.out.println("Finished importing");
    }

    private static boolean areThreeArgs(String s) {
        return s.split(" ").length == 3;
    }

    private static boolean isImport(String s) {
        return s.split(" ")[0].equals("import");
    }
}
