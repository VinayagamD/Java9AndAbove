package com.vinaylogics.corejavatraining.oops.basics.cbvvscbr;

public class MethodByReference {

    public static void main(String[] args) {
        MethodByReference methodByReference = new MethodByReference();
        methodByReference.callTheMethod(methodByReference);
    }

    public void callTheMethod(MethodByReference methodByReference){
        methodByReference.printMethod();
    }

    public void printMethod(){
        System.out.println("Print Method called");
    }
}
