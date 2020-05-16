package com.vinay.streammeetup.functionalinterface;

import java.util.ArrayList;

public class LambdaFunc2 {

    public static void main(String[] args) {
        // Creating an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        // Using lambda expression to print all elements
        // of arrL
        System.out.println("--------------- Odd Numbers --------------------");
        arrL.forEach(System.out::println);

        // Using lambda expression to print even elements
        // of arrL
        System.out.println("---------------- Even Numbers -------------------");
        arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); });
    }
}
