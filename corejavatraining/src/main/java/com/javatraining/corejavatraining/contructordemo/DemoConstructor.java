package com.javatraining.corejavatraining.contructordemo;

public class DemoConstructor {
    int data;
    String name;
    /*public DemoConstructor(){
        System.out.println("Demo Constructor Called");
    }*/
   /* public DemoConstructor(int data, String name) {
        this.data = data;
        this.name = name;
    }*/

    public static void main(String[] args) {
        DemoConstructor demoConstructor = new DemoConstructor();
//        demoConstructor.DemoConstructor();
        System.out.println(demoConstructor.name);
        System.out.println(demoConstructor.data);
        int a=0;
        System.out.println(a);
//        Child child = new Child();
    }
}
