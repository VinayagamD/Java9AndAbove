package com.javatraining.corejavatraining.oops;

public class TestThis {

    private int x;

    public static void main(String[] args) {
        TestThis testThis = new TestThis();
        System.out.println(testThis);
        testThis.test1();
//        System.out.println(this);
    }

    public void test1(){
        System.out.println(this);
        System.out.println(this.x);
        this.test1(10);
        System.out.println(this.x);
        System.out.println(x);
    }

    public void test1(int x){
        System.out.println(x);
        this.x = x;
//        x = x;
    }
}
