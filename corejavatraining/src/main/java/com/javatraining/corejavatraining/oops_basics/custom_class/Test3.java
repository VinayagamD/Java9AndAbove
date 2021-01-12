package com.javatraining.corejavatraining.oops_basics.custom_class;

import com.javatraining.corejavatraining.oops_basics.custom_class.test.Test;


public class Test3 {

    static int data = 10;
    int data2 = 20;

    public static void main(String[] args) {
        Test test = new Test();
        Test3 test3 = new Test3();
        System.out.println(data);
        System.out.println(test3.data2);
        test3.testMethod();
    }

    public void testMethod(){
        System.out.println(data);
        System.out.println(data2);
        System.out.println(this.data2);
    }
}
