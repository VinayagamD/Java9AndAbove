package com.javatraining.corejavatraining.stativvsinstance;

public class FinalInstanceDemo {
//    final String data = "";
    final String data;
//    final static String staticData = "";
    final static String staticData;
    static {
        staticData = "";
    }

    /*{
        data = "";
    }*/

    public FinalInstanceDemo(){
        data = "";
//        staticData = "";
    }

}
