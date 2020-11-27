package com.javatraining.corejavatraining.oops.inherintance;

public class BaseRoot {

    protected void classRootMethod(){
        System.out.println("Class Root Method");
    }

    public static void staticMethod(){
        System.out.println("This Static Method");
    }

    void defaultMethod(){
        System.out.println("This is default method");
    }

    public static void staticMethod(int a){
        System.out.println(a);
    }

    public void rootMethod2(){
        System.out.println("Root Method");
    }
    public void rootMethod2(int a){
        System.out.println(a);
    }

    public final void rootMethod3(){
        System.out.println("This is final method cannot be overridden");
    }

    private void privateMethod(){
        System.out.println("This is private");
    }
}
