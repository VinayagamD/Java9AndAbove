package com.javatraining.corejavatraining.training.puzzle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class helps to test BI for {@link AdditionUtil}
 */
class AdditionUtilTest {

    // Test Instance for validating BI
    AdditionUtil testInstance;

    /**
     * Setup method for creating instance
     */
    @BeforeEach
    void setUp() {
        testInstance = new AdditionUtil();
    }

    /**
     * Test for Method {@link AdditionUtil#processResult(int, int)}
     */
    @Test
    @DisplayName("Validate addition function is working properly")
    void processResult() {
        // Data 1
        int data1 = 10;
        int data2 = 20;
        int expected = data1+data2;

        // Test the actual function
        int actual = testInstance.processResult(data1, data2);
        assertEquals(expected,actual);

        // Data 2
        data1 = 30;
        data2 = 60;
        expected = data1+data2;
        actual = testInstance.processResult(data1, data2);
        assertEquals(expected,actual);
    }
}