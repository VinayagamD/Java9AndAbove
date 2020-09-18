package com.javatraining.corejavatraining.streams.csvhelpers;

import com.javatraining.corejavatraining.streams.csvhelpers.exceptions.CSVException;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSVData implements Serializable {

    private CSVColumn csvHeaders;
    private List<CSVColumn> csvRows;
    private boolean isHeaderPresent;
    private Builder builder;

    private CSVData(Builder builder) {
        this.builder = builder;
        this.csvHeaders = builder.csvHeaders;
        this.csvRows = builder.csvRows;
        this.isHeaderPresent = builder.isHeaderPresent;
    }

    public CSVColumn getCsvHeaders() {
        return csvHeaders;
    }

    public List<CSVColumn> getCsvRows() {
        return csvRows;
    }

    public List<String> getColumnData(String key) throws CSVException {
        if(!isHeaderPresent){
            throw new CSVException("Header not present for csv");
        }
        csvHeaders.getValues().stream().filter(csvHeader -> csvHeader.equals(key)).findAny().orElseThrow(()->new CSVException("Key Not Found"));
        return csvRows.stream().map(csvColumn -> csvColumn.getValues().get(csvHeaders.getValues().indexOf(key))).collect(Collectors.toList());
    }

    public boolean isHeaderPresent() {
        return isHeaderPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSVData csvData = (CSVData) o;
        return isHeaderPresent == csvData.isHeaderPresent &&
                Objects.equals(csvHeaders, csvData.csvHeaders) &&
                Objects.equals(csvRows, csvData.csvRows) &&
                Objects.equals(builder, csvData.builder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csvHeaders, csvRows, isHeaderPresent, builder);
    }



    @Override
    public String toString() {
        return "CSVData{" +
                "csvHeaders=" + csvHeaders +
                ", csvRows=" + csvRows +
                ", isHeaderPresent=" + isHeaderPresent +
                ", builder=" + builder +
                '}';
    }

    public static class Builder {
        private CSVColumn csvHeaders;
        private List<CSVColumn> csvRows;
        private boolean isHeaderPresent;

        public Builder setCsvHeaders(CSVColumn csvHeaders) {
            this.csvHeaders = csvHeaders;
            return this;
        }

        public Builder setCsvRows(List<CSVColumn> csvRows) {
            this.csvRows = csvRows;
            return this;
        }

        public Builder setHeaderPresent(boolean headerPresent) {
            isHeaderPresent = headerPresent;
            return this;
        }

        public CSVData build(){
            return new CSVData(this);
        }

    }
}
