package com.javatraining.corejavatraining.package_hierachy;

import java.util.Objects;

public class Data {

    int data;

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Data)) return false;
        return data == ((Data)o).data;
    }

    @Override
    public int hashCode() {
        return data;
    }


    @Override
    public String toString() {
        return "Data {"+
                "data="+data+
                "}";
    }

    public static void main(String[] args) {
        Data data = new Data();
        Data data1 = new Data();
        data.data = 10;
        data1.data = 10;
        System.out.println(data.equals(data1));
        data1.data = 20;
        System.out.println(data.equals(data1));
        System.out.println(data);
        System.out.println(data1);
    }
}
