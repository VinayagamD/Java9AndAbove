package com.vinaylogics.corejavatraining.oops.basics.thisexample;

public class ThisExample {

    private int data;

    public void test(int data){
        System.out.println(data);
        System.out.println(this.data);
        System.out.println(super.toString());
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        ThisExample te = new ThisExample();
        System.out.println(te);
        te.test(10);
        te.data = 20;
        System.out.println(te.data);
    }
}
