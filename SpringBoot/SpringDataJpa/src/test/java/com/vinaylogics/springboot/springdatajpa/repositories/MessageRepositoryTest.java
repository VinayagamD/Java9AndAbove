package com.vinaylogics.springboot.springdatajpa.repositories;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springdatajpa.models.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(MessageRepositoryTest.class.getSimpleName());

    @Autowired
    private MessageRepository repository;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    @DisplayName("Test Save Model")
    void testSaveMessage(){
        Message message = new Message();
        message.setName(faker.funnyName().name());
        message.setMessage(faker.food().dish());
        System.out.println(message);
        repository.save(message);
        System.out.println(message);
    }

    @Test
    @DisplayName("Test Count Message")
    void testCount(){
        Long count = repository.getCount();
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @ParameterizedTest(name = "Find Message By valid id = {0}")
    @ValueSource(longs = {1,2,3,4,5})
    void testFindSingleMessage(Long id){
        Optional<Message> actualMessage = repository.findSingleMessage(id);
        assertNotNull(actualMessage);
        assertTrue(actualMessage.isPresent());
        LOG.debug("%s",actualMessage.get().toString());
    }

    @Test
    @DisplayName("Paging Data test")
    void testDataPaging(){
        Page<Message> messages = repository.findAll(PageRequest.of(0,10));
        System.out.println(messages.getTotalPages());
        messages.get().forEach(System.out::println);
    }

    @AfterEach
    void tearDown() {
    }
}