package com.gebre.tdd.demo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllStudents() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/all")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
    }
    @Test
    public void addStudent() throws Exception{

        String student= "{\n" +
                "name: \"Gebre\",\n" +
                "age:32,\n" +
                "department:\"Computer Science\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(student)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is(400)).andReturn();
    }
}
