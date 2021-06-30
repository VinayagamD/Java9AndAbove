package com.javatraining.corejavatraining.method_params;

public class CallByValueVsReference {

    public void callByValue(int a){
        System.out.println(a);
    }

    public void callByRef(CallByValueVsReference callByValueVsReference){
        System.out.println(callByValueVsReference);
    }

    public static void main(String[] args) {
        CallByValueVsReference cBVVR =  new CallByValueVsReference();
        cBVVR.callByValue(10);
        cBVVR.callByRef(cBVVR);
    }
}
