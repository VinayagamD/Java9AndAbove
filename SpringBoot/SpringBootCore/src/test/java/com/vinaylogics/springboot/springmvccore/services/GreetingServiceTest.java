package com.vinaylogics.springboot.springmvccore.services;

import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.provider.MessageProvider;
import com.vinaylogics.springboot.springmvccore.util.DataProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GreetingServiceTest {

    @Autowired
    private GreetingService service;

    @MockBean
    private MessageProvider messageProvider;

    @Autowired
    private DataProvider dataProvider;

    @Test
    @DisplayName("Find all Message")
    void testFindAllMessage(){
        List<Message> expected = dataProvider.provideMessage();
        Mockito.when(messageProvider.findAll()).thenReturn(expected);
        List<Message> actual = service.findAll();
        Mockito.verify(messageProvider, Mockito.times(1)).findAll();
        assertEquals(expected,actual);
        assertEquals(expected.size(),actual.size());
        expected.forEach(message ->{
            assertEquals(message,actual.get(expected.indexOf(message)));
        });
    }

    @Test
    @DisplayName("Find all Message When No Message")
    void testFindAllMessage_ReturnsEmptyList(){
        List<Message> expected = new ArrayList<>();
        Mockito.when(messageProvider.findAll()).thenReturn(expected);
        List<Message> actual = service.findAll();
        Mockito.verify(messageProvider, Mockito.times(1)).findAll();
        assertEquals(expected,actual);
        assertTrue(actual.isEmpty());
        assertEquals(expected.size(),actual.size());
    }

}