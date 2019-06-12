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
@WebMvcTest(ReverseController.class)
public class ReverseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void reverseTest() throws Exception{

        mvc.perform(get("/reverse?sentence=hello baba")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("baba hello")));
    }

    @Test
    public void reverseTestSingle() throws Exception{

        mvc.perform(get("/reverse?sentence=doing")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("doing")));
    }

    @Test
    public void reverseTestNoVariable() throws Exception{

        mvc.perform(get("/reverse")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}