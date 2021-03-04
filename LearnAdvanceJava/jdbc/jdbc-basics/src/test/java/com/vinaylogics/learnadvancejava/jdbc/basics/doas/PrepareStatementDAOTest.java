package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PrepareStatementDAOTest {
    PrepareStatementDAO prepareStatementDAO;
    @BeforeEach
    void setUp() {
        prepareStatementDAO = new PrepareStatementDAO();
    }

    @Test
    void getTestDataList() {
        prepareStatementDAO.getTestDataList().forEach(System.out::println);
    }

    @ParameterizedTest(name = "Select Test data for valid id={0}")
    @ValueSource(longs = {1,2,3,4,5})
    void getTestData_ForValidId(Long id){
        TestData testData = prepareStatementDAO.getTestData(id);
        assertNotNull(testData);
        assertEquals(testData.getId(), id);
        System.out.println(testData);
    }

    @ParameterizedTest(name = "Select Test data for invalid id={0}")
    @ValueSource(longs = {100001,100002,100003,100004,100005})
    void getTestData_ForInvalidId(Long id) {
        TestData testData = prepareStatementDAO.getTestData(id);
        assertNull(testData);
    }
    @ParameterizedTest(name = "Saving Test data for name={0}")
    @ValueSource(strings = {"name1", "name2", "name3", "name4","name5"})
    void saveTestData(String name) {
        TestData actual = prepareStatementDAO.saveTestData(new TestData(name));
        assertNotNull(actual);
        assertEquals(name,actual.getName());
        assertTrue(actual.getId() > 0);
        System.out.println(actual);
    }

    @ParameterizedTest(name = "Update Test data for valid id={0}")
    @ValueSource(longs = {31,32,33,34,35})
    void updateTestData(long id) {
        TestData fetchedData = prepareStatementDAO.getTestData(id);
        assertNotNull(fetchedData);
        fetchedData.setName("UpdatedName"+id);
        TestData actualData = prepareStatementDAO.updateTestData(fetchedData);
        assertSame(fetchedData,actualData);
    }

    @ParameterizedTest(name = "Delete Test data for valid id={0}")
    @ValueSource(longs = {81,82,83,84, 85})
    void deleteTestData(Long id) {
        TestData fetchedData = prepareStatementDAO.getTestData(id);
        assertNotNull(fetchedData);
        assertTrue(prepareStatementDAO.deleteTestData(fetchedData));
    }
}