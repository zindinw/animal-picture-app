package com.example.animalapp.controller;

import com.example.animalapp.repository.AnimalPictureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalPictureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AnimalPictureRepository repo;

    @BeforeEach
    void setup() {
        repo.deleteAll();
    }

    @Test
    void saveAndFetchCatPicture() throws Exception {
        mockMvc.perform(post("/api/pictures/save?animal=cat&count=1"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/pictures/last?animal=cat"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.animalType").value("cat"));
    }
}