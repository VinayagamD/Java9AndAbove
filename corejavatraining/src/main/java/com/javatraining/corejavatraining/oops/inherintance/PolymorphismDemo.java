package com.javatraining.corejavatraining.oops.inherintance;

public class PolymorphismDemo {
    BaseRoot baseRoot;
    public static void main(String[] args) {
        BaseRoot baseRoot = new DerivedClass(); // Auto upcasting
        baseRoot.classRootMethod();
//        baseRoot.derivedMethod1();
//
    if (baseRoot instanceof DerivedClass){
        ((DerivedClass) baseRoot).derivedMethod1(); // Down casting
        DerivedClass derivedClass = (DerivedClass) baseRoot;
        derivedClass.derivedMethod1();
        derivedClass.classRootMethod();
        derivedClass.rootMethod2();
    }

        Object objectClass = new DerivedClass();
        ((BaseRoot)objectClass).classRootMethod();
//        DerivedClass derivedClass1 = new BaseRoot();
      /* baseRoot = null;
       baseRoot.classRootMethod();*/
       PolymorphismDemo polymorphismDemo = new PolymorphismDemo();
       polymorphismDemo.baseRoot = new DerivedClass();
       polymorphismDemo.baseRoot.classRootMethod();

    }
}
