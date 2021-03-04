package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BatchInsertDaoTest {

    BatchInsertDao batchInsertDao;

    @BeforeEach
    void setUp() {
        batchInsertDao = new BatchInsertDao();
    }

    @Test
    void insertList() {
        List<TestData> testData = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach(i ->{
            testData.add(new TestData("InsertName->"+i));
        });
        batchInsertDao.insertList(testData);
    }

    @Test
    void savePointList() {
        List<TestData> testData = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach(i ->{
            testData.add(new TestData("SInsertName->"+i));
        });
        batchInsertDao.savePointList(testData);
    }
}