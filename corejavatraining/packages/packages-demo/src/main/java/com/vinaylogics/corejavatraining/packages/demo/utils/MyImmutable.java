package com.vinaylogics.corejavatraining.packages.demo.utils;

public record MyImmutable(String data) {

    public String getData() {
        return data;
    }

    public static void main(String[] args) {
        MyImmutable myImmutable = new MyImmutable("Shanthi");
        System.out.println(myImmutable.getData());
        myImmutable = new MyImmutable("Java");
        System.out.println(myImmutable.getData());

    }
}
