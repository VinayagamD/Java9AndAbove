package com.vinaylogics.springboot.springmvccore.provider;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springmvccore.models.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageProviderTest {

    @Autowired
    private MessageProvider messageProvider;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    @DisplayName("Test Message Provider Find All")
    void findAll() {
        List<Message> messages = messageProvider.findAll();
        assertNotNull(messages);
        assertEquals(messages.size(), 100);
        messages.forEach(System.out::println);
    }

    @ParameterizedTest(name = "Test For Existing Message id = {0}")
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void findById_Success(Long id) {
        Optional<Message> message = messageProvider.findById(id);
        assertTrue(message.isPresent());
        assertEquals(id, message.get().getId());
    }

    @ParameterizedTest(name = "Test For Non Existing Message id = {0}")
    @ValueSource(longs = {200, 300, 250, 301})
    void findById_NotExistingId_EmptyMessage(Long id) {
        Optional<Message> message = messageProvider.findById(id);
        assertTrue(message.isEmpty());
    }

    @Test
    void save() {
        Message expected = new Message();
        expected.setName("Anand");
        expected.setMessage(faker.food().dish());

        Message actual = messageProvider.save(expected);

        assertNotNull(actual);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getMessage(), actual.getMessage());
    }

    @ParameterizedTest(name = "Update message for id = {0}")
    @ValueSource(longs = {1, 2, 3, 4, 5, 6})
    void testUpdate_MessageWithExistingId(Long id) {
        Optional<Message> optionalMessage = messageProvider.findById(id);
        assertNotNull(optionalMessage);
        assertTrue(optionalMessage.isPresent());
        Message expected = optionalMessage.get();
        expected.setMessage(faker.food().dish());
        try {
            Message actual = messageProvider.update(id, optionalMessage.get());
            assertEquals(expected.getMessage(),actual.getMessage());
        } catch (RuntimeException e) {
            fail("Unexpected Exception", e);
        }
    }

    @ParameterizedTest(name = "Update message for non existing id = {0} throws runtime exception")
    @ValueSource(longs = {200, 201, 203, 204, 205, 206})
    void testUpdate_MessageWithNonExistingId(Long id) {
        Optional<Message> optionalMessage = messageProvider.findById(id);
        assertNotNull(optionalMessage);
        assertTrue(optionalMessage.isEmpty());
        Message expected = optionalMessage.orElse(null);
        try {
            messageProvider.update(id, expected);
            fail("Expected Exception");
        } catch (RuntimeException e) {
            assertEquals("Message with id="+id+" Not Found",e.getMessage());
        }
    }
}