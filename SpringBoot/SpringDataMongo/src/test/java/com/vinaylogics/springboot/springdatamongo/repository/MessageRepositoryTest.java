package com.vinaylogics.springboot.springdatamongo.repository;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springdatamongo.models.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository repository;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    @DisplayName("Test get all messages")
    void testSelectAll(){
        repository.findAll().forEach(System.out::println);
    }

    @Test
    @DisplayName("Test Save Message")
    void testSaveData(){
        Message expected = Message.builder().message(faker.food().dish())
                .name(faker.funnyName().name())
                .build();
       Message actual= repository.save(expected);
        System.out.println(actual);
    }
}