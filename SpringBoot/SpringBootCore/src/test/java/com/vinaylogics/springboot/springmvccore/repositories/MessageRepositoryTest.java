package com.vinaylogics.springboot.springmvccore.repositories;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springmvccore.configs.DefaultRegistryConfig;
import com.vinaylogics.springboot.springmvccore.models.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    private Faker faker;

    @BeforeEach
    void setUp(){
        faker = new Faker();
    }

    @Test
    @DisplayName("Test save for message")
    void testSaveMessage(){
        Message expected = new Message();
        expected.setMessage(faker.food().dish());
        expected.setName(faker.funnyName().name());
        Message actual = messageRepository.save(expected);
        assertNotNull(actual);
        assertEquals(expected.getMessage(),actual.getMessage());
        assertEquals(expected.getName(),actual.getName());
    }


    @RepeatedTest(20)
    @DisplayName("Test save for message")
    void testSaveMessageRepeated(){
        Message expected = new Message();
        expected.setMessage(faker.food().dish());
        expected.setName(faker.funnyName().name());
        Message actual = messageRepository.save(expected);
        assertNotNull(actual);
        assertEquals(expected.getMessage(),actual.getMessage());
        assertEquals(expected.getName(),actual.getName());
    }

    @ParameterizedTest(name = "Test message for id={0}")
    @ValueSource(longs = {1,2,3,4,5})
    void testGetMessage_ForValidIds(Long id){
        Optional<Message> actualMessage = messageRepository.findById(id);
        assertTrue(actualMessage.isPresent());
        assertEquals(actualMessage.get().getId(),id);
    }
}