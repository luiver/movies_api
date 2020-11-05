package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.*;
import com.codecool.moviesapi.service.GenericService;
import com.codecool.moviesapi.service.csvservice.CsvHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @MockBean
    private CsvHandler csvHandler;

    @Autowired
    private MovieController movieController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private @Qualifier("movieService") GenericService<Movie> movieGenericService;

    @Test
    public void getMovieById() throws Exception {
        Movie movie = new Movie(1L, "gary move out", 1989,
                "picture of man exploring the wild rivers and documenting life of alligators");
        
        when(movieGenericService.getById(anyLong())).thenReturn(movie);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("title").value("gary move out"))
                .andExpect(MockMvcResultMatchers.jsonPath("year").value("1989"))
                .andExpect(status().isOk());
    }

}