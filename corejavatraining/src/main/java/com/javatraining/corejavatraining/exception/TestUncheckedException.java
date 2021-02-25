package com.javatraining.corejavatraining.exception;

public class TestUncheckedException {

    public static void main(String[] args)  {
        try {
            throw new MyRuntimeException("Purposeful exception");
        } catch (MyRuntimeException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Finally Called");
        }
    }
}
