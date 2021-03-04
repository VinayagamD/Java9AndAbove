package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDaoTest {
    TransactionDao transactionDao;
    @BeforeEach
    void setUp() {
        transactionDao = new TransactionDao();
    }

    @ParameterizedTest(name = "Saving Test data for name={0}")
    @ValueSource(strings = {"tName1", "tName2", "tName3", "tName4", "tName5"})
    void saveRecordNotCommit(String name) {
        System.out.println(transactionDao.saveRecordNotCommit(new TestData(name)));
    }

    @ParameterizedTest(name = "Saving Test data for name={0}")
    @ValueSource(strings = {"tName1", "tName2", "tName3", "tName4", "tName5"})
    void saveRecordCommit(String name) {
        System.out.println(transactionDao.saveRecordCommit(new TestData(name)));
    }

    @ParameterizedTest(name = "Saving Test data for name={0}")
    @ValueSource(strings = {"rName1", "rName2", "rName3", "rName4", "rName5"})
    void saveRecordRollback(String name) {
        System.out.println(transactionDao.saveRecordRollback(new TestData(name)));
    }
}