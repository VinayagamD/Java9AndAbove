/**
 * 
 */
package com.vinaylogics.learnadvancedjava.junit;


import org.junit.jupiter.api.*;

/**
 * @author vinay
 *
 */
public class TestingLifeCycle {


    // Run once, e.g. Database connection, connection pool
    @BeforeAll
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterAll
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @BeforeEach
    public void runBeforeTestMethod() {
    	System.out.println();
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @AfterEach
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
        System.out.println();
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }
}
