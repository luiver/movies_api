package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Country;
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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @MockBean
    private CsvHandler csvHandler;

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private @Qualifier("countryService") GenericService<Country> countryGenericService;

    @Test
    public void getCountryById() throws Exception {
        Country country = new Country();
        country.setId(12L);
        country.setName("Poland");
        country.setIsActive(true);

        when(countryGenericService.getById(anyLong())).thenReturn(country);

        mockMvc.perform(MockMvcRequestBuilders.get("/countries/12"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(12L))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Poland"))
                .andExpect(status().isOk());
    }
}