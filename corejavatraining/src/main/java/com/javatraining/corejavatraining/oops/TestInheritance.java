package com.javatraining.corejavatraining.oops;

import com.javatraining.corejavatraining.oops.inherintance.BaseRoot;
import com.javatraining.corejavatraining.oops.inherintance.SubDerivedClass;

public class TestInheritance {
    public static void main(String[] args) {
        BaseRoot baseRoot = new BaseRoot();
        SubDerivedClass subDerivedClass = new SubDerivedClass();
        subDerivedClass.classRootMethod();
    }
}
