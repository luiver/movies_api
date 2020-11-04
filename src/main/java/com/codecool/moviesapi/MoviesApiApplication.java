package com.codecool.moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesApiApplication {
    static String[] arguments;

    @Bean
    public static String[] getArguments() {
        return arguments;
    }

    public static void main(String[] args) {
        arguments = args;
        SpringApplication.run(MoviesApiApplication.class, args);
    }
}
