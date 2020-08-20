package com.javatraining.corejavatraining.stativvsinstance;

public class Demo {

    static String staticData;
    String instanceData;

    public static void main(String[] args) {
        String  data = null;
        System.out.println(staticData);
        //  System.out.println(instanceData); Cannot access variable
        Demo demo = new Demo();
        System.out.println(demo.instanceData); // Can access variable
        System.out.println(data);
    }
}
