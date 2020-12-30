package com.vinaylogics.springboot.springmvccore.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.services.GreetingService;
import com.vinaylogics.springboot.springmvccore.util.DataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.vinaylogics.springboot.springmvccore")
@ContextConfiguration(classes = {DataProvider.class})
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Autowired
    private DataProvider dataProvider;

    private ObjectMapper mapper;

    @BeforeEach
    void setUp(){
        mapper = new ObjectMapper();
    }

    @Test
    void allMessages() throws Exception {
        List<Message> expected = dataProvider.provideMessage();
        when(service.findAll()).thenReturn(expected);
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"));
        actions.andExpect(status().isOk());
        String response = actions.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        List<Message> actual = mapper.readValue(response, new TypeReference<>(){});
        assertEquals(expected,actual);
    }
}