package com.vinaylogics.corejavatraining.oops.basics.staticvsinstance;

public class StaticVsInstance {

    static int sData = 10;
    int iData = 20;
//    public StaticVsInstance gsvi = new StaticVsInstance();
    public static StaticVsInstance gssvi = new StaticVsInstance();

    public static void main(String[] args) {
        System.out.println("================= Static Access =============");
        sMethod();
        System.out.println(sData);
        StaticVsInstance.sMethod();
        System.out.println(StaticVsInstance.sData);
        System.out.println();
        System.out.println("================= Instance Access =============");
        StaticVsInstance svi = new StaticVsInstance();
        System.out.println(svi.iData);
        svi.iMethod();
        System.out.println(gssvi);
    }

    public static void sMethod(){
        System.out.println("This is the static method");
        System.out.println("Static can only access static variable and static method");
        System.out.println(sData);
    }

    public void iMethod(){
        System.out.println("This is the instance method");
        System.out.println("Instance method can access both static and instance variable and method");
        System.out.println(sData);
        System.out.println(iData);
        sMethod2();
        iMethod2();
    }

    public void sMethod2(){
        System.out.println("This the static method 2");
    }

    public void iMethod2(){
        System.out.println("This is the instance method2");

    }
}
