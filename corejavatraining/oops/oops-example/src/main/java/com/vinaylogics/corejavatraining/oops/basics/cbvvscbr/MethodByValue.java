package com.vinaylogics.corejavatraining.oops.basics.cbvvscbr;

public class MethodByValue {

    public static void main(String[] args) {
        MethodByValue methodByValue = new MethodByValue();
        methodByValue.callMethodByValue(10, 20.56f);
    }

    public void callMethodByValue(int a, float b){
        System.out.println("A = "+a +", B = " +b);
    }
}
