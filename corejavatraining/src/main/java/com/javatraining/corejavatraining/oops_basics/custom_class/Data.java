package com.javatraining.corejavatraining.oops_basics.custom_class;

public class Data {

    public static int sData = 20;
    public int iData = 30;

    public static void sMethod(){
        System.out.println(sData);
//        System.out.println(iData);
        System.out.println("Static Method");
//        iMethod();
    }

    public void iMethod(){
        System.out.println(iData);
        System.out.println(sData);
        sMethod();
        System.out.println("Instance Method");
    }
}
