package com.vinaylogics.springbootcore.configs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoreConfigsTest {

    @Autowired
    private CoreConfigs coreConfigs;

    @Test
    @DisplayName("To test String Bean Method")
    void name() {
        String expected = "Name";
        String actual = coreConfigs.name();
        assertEquals(expected,actual);
    }

    @Test
    void name2() {
    }

    @Test
    void numInt() {
    }

    @Test
    void timeStamp() {
    }

    @Test
    void list() {
    }

    @Test
    void set() {
    }

    @Test
    void map() {
    }

    @Test
    void product() {
    }

    @Test
    void myModel() {
    }
}