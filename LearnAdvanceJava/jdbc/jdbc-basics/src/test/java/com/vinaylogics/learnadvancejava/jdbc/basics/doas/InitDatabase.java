package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.github.javafaker.Faker;
import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class InitDatabase {

    StatementDAO statementDAO;
    Faker faker;
    @BeforeEach
    public void setUp(){
        statementDAO = new StatementDAO();
        faker = new Faker();
    }

    @RepeatedTest(1000)
    public void testInsertSampleData(){
        TestData testData = new TestData(faker.name().fullName());
        statementDAO.saveTestData(testData);
    }

}
