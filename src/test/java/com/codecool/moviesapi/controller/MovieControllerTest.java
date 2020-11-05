package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Movie;
import com.codecool.moviesapi.service.GenericService;
import com.codecool.moviesapi.service.csvservice.CsvHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    private @Qualifier("movieService")
    GenericService<Movie> movieGenericService;

    @Test
    public void should_returnExpectedValues_when_MovieGetByID() throws Exception {
        //Arrange
        Movie movie = new Movie();
        movie.setId(20L);
        movie.setYear(1992);
        movie.setTitle("Awesome_Movie");
        movie.setDescription("movie_description");
        //Act
        when(movieGenericService.getById(anyLong())).thenReturn(movie);
        //Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/20"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("year").value(1992))
                .andExpect(MockMvcResultMatchers.jsonPath("title").value("Awesome_Movie"))
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("movie_description"))
                .andExpect(status().isOk());
    }

    @Test
    void should_returnStatus201Created_when_AddNewMovieWithProperData() throws Exception {
        //Arrange
        Movie movie = new Movie();
        movie.setId(20L);
        movie.setYear(1992);
        movie.setTitle("Awesome_Movie");
        movie.setDescription("movie_description");
        //Act

        //Assert
        mockMvc.perform(post("/movies")
                .content(new ObjectMapper().writeValueAsString(movie))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void should_returnStatus400_when_AddNewMovieWithMissingNotNullData() throws Exception {
        //Arrange
        Movie movie = new Movie();
        movie.setId(20L);
        movie.setTitle("Awesome_Movie");
        movie.setDescription("movie_description");
        //Act

        //Assert
        mockMvc.perform(post("/movies")
                .content(new ObjectMapper().writeValueAsString(movie))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void should_return404_when_EndpointNotExists() throws Exception {
        //Act
        when(movieGenericService.getById(anyLong())).thenReturn(null);
        //Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/20"))
                .andDo(print())
                .andExpect(status().isNotFound());
        //Assert
    }
}