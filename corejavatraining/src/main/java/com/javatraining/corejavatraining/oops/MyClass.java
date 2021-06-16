package com.javatraining.corejavatraining.oops;

import java.io.Serializable;

class MyClass implements Serializable, Cloneable{

    int instanceVar;
    static int staticVar;

    public MyClass() {
        super();
    }

    public static void main(String[] args) {
        System.out.println(staticVar);
        MyClass myClass = new MyClass();
        System.out.println(myClass);
        System.out.println(myClass.toString());
        System.out.println(myClass.hashCode());
        System.out.println(myClass.equals(myClass));
        System.out.println(myClass == myClass);
        System.out.println(myClass.instanceVar);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "My Class Replaced String";
    }

    public class InnerClass{

    }
}
