package com.javatraining.corejavatraining.oopsdetails.inheritance.reference;

public class Test {

    public static void main(String[] args) {
        Object obj = new SubChild();
        ((SubChild)obj).subChild();
        //((SubChild2)((Child)((Parent)obj))).subChild2();
        if (obj instanceof SubChild){
            System.out.println("Subchild Instance");
            ((SubChild)((Child)((Parent)obj))).subChild();
        }

        if (obj instanceof SubChild2){
            System.out.println("Subchild2 Instance");
            ((SubChild2)((Child)((Parent)obj))).subChild2();
        }

        System.out.println(obj instanceof SubChild2);
        System.out.println(obj instanceof SubChild);
    }
}
