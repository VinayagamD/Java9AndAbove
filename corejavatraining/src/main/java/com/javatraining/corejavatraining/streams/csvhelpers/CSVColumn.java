package com.javatraining.corejavatraining.streams.csvhelpers;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CSVColumn implements Serializable {

    public  enum Type {
        HEADER,
        ROWS
    }

    private List<String> values;
    private Type type;

    public CSVColumn(Type type, String[] values){
        this.type = type;
        this.values = Arrays.asList(values);
    }

    public CSVColumn(Type type, List<String> values){
        this.type = type;
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSVColumn csvColumn = (CSVColumn) o;
        return Objects.equals(values, csvColumn.values) &&
                type == csvColumn.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, type);
    }

    @Override
    public String toString() {
        return "CSVColumn{" +
                "values=" + values +
                ", type=" + type +
                '}';
    }
}
