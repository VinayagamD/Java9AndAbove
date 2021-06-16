package com.javatraining.corejavatraining.oops;

public class TestVariable {

    public static int a = 10;
    public int b = 20;

    public static void main(String[] args) {
        TestVariable tv = new TestVariable();
        System.out.println(a);
        System.out.println(tv.b);
        test1();
        tv.test2();
    }

    public static void test1(){
        System.out.println("Test1");
    }

    public void test2(){
        System.out.println("Test2");
    }
}
