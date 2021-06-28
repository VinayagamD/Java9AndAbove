package com.javatraining.corejavatraining.oops_basics.custom_class;

public class TestData {

    public static void main(String[] args) {
        Data.sMethod();
        System.out.println(Data.sData);
        Data data = new Data();
        System.out.println(data.iData);
        data.iMethod();
        System.out.println(data);
    }
}
