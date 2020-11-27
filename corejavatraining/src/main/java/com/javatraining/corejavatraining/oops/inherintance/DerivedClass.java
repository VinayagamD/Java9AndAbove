package com.javatraining.corejavatraining.oops.inherintance;

public class DerivedClass  extends BaseRoot{


    public void derivedMethod1(){
        System.out.println("derivedMethod1");
    }

    public void derivedMethod2() {
        System.out.println("derivedMethod2");
    }

    @Override
    public void rootMethod2() {
        super.rootMethod2();
        System.out.println("derivedMethod2 rootMethod2");
    }





    @Override
    protected void classRootMethod() {
        super.classRootMethod();
    }

    @Override
    public String toString() {
        return "DerivedClass{}";
    }
}
