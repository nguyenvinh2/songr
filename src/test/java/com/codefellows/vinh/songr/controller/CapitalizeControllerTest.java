package com.codefellows.vinh.songr.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CapitalizeController.class)
public class CapitalizeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void capitalizeTest() throws Exception{

        mvc.perform(get("/capitalize/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("HELLO")));
    }

    @Test
    public void capitalizeTestMultiple() throws Exception{

        mvc.perform(get("/capitalize/hello and how are you doing")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("HELLO AND HOW ARE YOU DOING")));
    }

    @Test
    public void capitalizeTestNoPathVariable() throws Exception{

        mvc.perform(get("/capitalize/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}