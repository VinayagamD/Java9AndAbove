package com.javatraining.corejavatraining.generics;

public class RestrictGenerics<T extends Number> {

    T t;

    public RestrictGenerics(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        RestrictGenerics<?> restrictGenerics = new RestrictGenerics<>(new SampleNumber());
//        RestrictGenerics<?> restrictGenerics2 = new RestrictGenerics<Test>(new Test());
    }
}
