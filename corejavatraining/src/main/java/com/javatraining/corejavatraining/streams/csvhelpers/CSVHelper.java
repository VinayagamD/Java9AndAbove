package com.javatraining.corejavatraining.streams.csvhelpers;

import com.javatraining.corejavatraining.streams.csvhelpers.exceptions.CSVException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    private static final Object LOCK = new Object();
    private File csvFile;
    private  boolean isHeaderExists;
    private  CSVData csvData;
    private  boolean isReadComplete;

    private static CSVHelper instance;
    private CSVHelper(){}

    public static CSVHelper getInstance() {
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = new CSVHelper();
                }
            }
        }
        return instance;
    }

    public  void setCsvFile(String file){
        csvFile = new File(file);
    }

    public  CSVData getCsvData() {
        return csvData;
    }

    public  boolean isIsReadComplete() {
        return isReadComplete;
    }

    public  void setIsHeaderExists(boolean isHeaderExists) {
        this.isHeaderExists = isHeaderExists;
    }

    public  boolean isValidFile() throws CSVException {
        if(csvFile == null){
            throw new CSVException("File Not Configured");
        }
        return csvFile.exists() || csvFile.isFile() ;
    }

    public  void parseCSV() throws CSVException{
        if(!isValidFile()){
            throw new CSVException("Invalid file configured");
        }
        try(FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            boolean isHeaderRead = false;
            CSVData.Builder builder = new CSVData.Builder();
            builder.setHeaderPresent(isHeaderExists);
            List<CSVColumn> csvColumns = new ArrayList<>();
            while ((line = bufferedReader.readLine())!= null){
                if(isHeaderExists && !isHeaderRead){
                    builder.setCsvHeaders(getColumns(CSVColumn.Type.HEADER,line));
                    isHeaderRead = true;
                }else {
                    csvColumns.add(getColumns(CSVColumn.Type.ROWS,line));
                }

            }
            csvData = builder.setCsvRows(csvColumns).build();
            isReadComplete = true;
        } catch (IOException e) {
            throw new CSVException(e.getMessage(), e);
        }

    }


    private  CSVColumn getColumns(CSVColumn.Type type,String values){
        return new CSVColumn(type,values.split(","));
    }
}
