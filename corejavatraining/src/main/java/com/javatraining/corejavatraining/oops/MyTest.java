package com.javatraining.corejavatraining.oops;

import java.util.Objects;

public class MyTest {

    private String data;

    public String getData() {
        return data;
    }

    public static void main(String[] args) {
        System.out.println(MyTest.class.getSimpleName());
        System.out.println(MyTest.class.getName());
        System.out.println(MyTest.class.getCanonicalName());
        System.out.println(MyTest.class.descriptorString());
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTest myTest = (MyTest) o;
        return Objects.equals(data, myTest.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "data='" + data + '\'' +
                '}';
    }
}
