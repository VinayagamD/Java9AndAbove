package com.javatraining.corejavatraining.instanceofeg;

public class TestInstance {

    public static void main(String[] args) {
        Parent p = new Child1();
        if(p instanceof Child2) {
            ((Child2) p).toString();
        }

        System.out.println(p instanceof Child2);
        System.out.println(p instanceof Child1);
        p = null;
        System.out.println(p instanceof Child1);
    }
}
