package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Country;
import com.codecool.moviesapi.entity.Person;
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

import java.sql.Date;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @MockBean
    private CsvHandler csvHandler;

    @Autowired
    private PersonController personController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private @Qualifier("personService")
    GenericService<Person> service;

    @Test
    void getPersonByIdTest() throws Exception {
        Person person = new Person();

        person.setName("Jan");
        person.setSurname("Kowalski");
        person.setDateOfBirth(Date.valueOf("1970-01-01"));
        person.setBio("Bio");
        person.setCountry(new Country("Poland"));
        person.setId(1L);

        when(service.getById(anyLong())).thenReturn(person);

        mockMvc.perform(MockMvcRequestBuilders.get("/people/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Jan"))
                .andExpect(MockMvcResultMatchers.jsonPath("surname").value("Kowalski"))
                .andExpect(MockMvcResultMatchers.jsonPath("bio").value("Bio"))
                .andExpect(MockMvcResultMatchers.jsonPath("dateOfBirth").value("1970-01-01"))
                .andExpect(status().isOk());
    }
}
