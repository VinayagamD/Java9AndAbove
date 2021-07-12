package com.javatraining.corejavatraining.streams.csvhelpers;

import com.javatraining.corejavatraining.streams.csvhelpers.exceptions.CSVException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CSVHelperTest {

    private CSVHelper csvHelper;
    @BeforeEach
    void setUp() {
        csvHelper = CSVHelper.getInstance();
    }

    @Test
    public void testParseCSV() throws Exception{
        csvHelper.setCsvFile(Objects.requireNonNull(csvHelper.getClass().getClassLoader().getResource("titanic_data.csv")).getFile());
        csvHelper.setIsHeaderExists(true);
        csvHelper.parseCSV();
        CSVData csvData = csvHelper.getCsvData();
        assertTrue(csvHelper.isIsReadComplete());
        assertNotNull(csvData);
        assertNotNull(csvData.getCsvHeaders());
        assertEquals(csvData.getCsvHeaders().getType(), CSVColumn.Type.HEADER);
        System.out.println(csvData.getCsvHeaders());
        assertNotNull(csvData.getCsvRows());
//        csvData.getCsvRows().forEach(System.out::println);
    }

    @Test
    public void testGetColumnDataForKey() throws Exception {
        testParseCSV();
        CSVData csvData = csvHelper.getCsvData();
        assertNotNull(csvData);
        csvData.getColumnData("Name").forEach(System.out::println);
    }

    @Test
    public void testGetColumnDataForNonExistKey() throws Exception {
        testParseCSV();
        CSVData csvData = csvHelper.getCsvData();
        assertNotNull(csvData);
        try {
            csvData.getColumnData("Test");
            fail("Expected Csv Exception");
        } catch (CSVException e) {
            assertNotNull(e);
            assertEquals(e.getMessage(), "Key Not Found");
            System.out.println(e.getMessage());
        }

    }

}