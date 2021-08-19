package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatementDAOTest {
    StatementDAO statementDAO;

    @BeforeEach
    void setUp() {
        statementDAO = new StatementDAO();
    }

    @Test
    @DisplayName("Test for getting list of data")
    void getTestDataList() {
        List<TestData> dataList = statementDAO.getTestDataList();
        assertNotNull(dataList);
        assertTrue(dataList.size()>0);
        dataList.forEach(System.out::println);
    }

    @ParameterizedTest(name = "Select Test data for valid id={0}")
    @ValueSource(longs = {1,2,3,4,5})
    void getTestData_ForValidId(Long id){
       TestData testData = statementDAO.getTestData(id);
       assertNotNull(testData);
       assertEquals(testData.getId(), id);
        System.out.println(testData);
    }

    @ParameterizedTest(name = "Select Test data for invalid id={0}")
    @ValueSource(longs = {100001,100002,100003,100004,100005})
    void getTestData_ForInvalidId(Long id) {
        TestData testData = statementDAO.getTestData(id);
        assertNull(testData);
    }

    @ParameterizedTest(name = "Saving Test data for name={0}")
    @ValueSource(strings = {"name1", "name2", "name3", "name4"})
    void saveTestData(String name) {
      TestData actual = statementDAO.saveTestData(new TestData(name));
      assertNotNull(actual);
      assertEquals(name,actual.getName());
      assertTrue(actual.getId() > 0);
      System.out.println(actual);
    }

    @ParameterizedTest(name = "Update Test data for valid id={0}")
    @ValueSource(longs = {31,32,33,34,35})
    void updateTestData(long id) {
        TestData fetchedData = statementDAO.getTestData(id);
        assertNotNull(fetchedData);
        fetchedData.setName("UpdatedName"+id);
        TestData actualData = statementDAO.updateTestData(fetchedData);
        assertSame(fetchedData,actualData);
    }

    @ParameterizedTest(name = "Delete Test data for valid id={0}")
    @ValueSource(longs = {114,115,116,117,118})
    void deleteTestData(Long id) {
        TestData fetchedData = statementDAO.getTestData(id);
        assertNotNull(fetchedData);
        assertTrue(statementDAO.deleteTestData(fetchedData));
    }
}