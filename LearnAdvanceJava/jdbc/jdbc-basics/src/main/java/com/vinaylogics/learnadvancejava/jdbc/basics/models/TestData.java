package com.vinaylogics.learnadvancejava.jdbc.basics.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class TestData implements Serializable {

    private Long id;
    private String name;

    public TestData() {
    }

    public TestData(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestData(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestData testData = (TestData) o;
        return Objects.equals(id, testData.id) && Objects.equals(name, testData.name);
    }

    public static TestData transform(ResultSet resultSet) throws SQLException {
        return new TestData(resultSet.getLong("id"),resultSet.getString("name"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TestData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
