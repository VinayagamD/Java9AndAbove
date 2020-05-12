package com.vinay.java9;

import java.util.stream.IntStream;

public class Range {

    public static void main(String[] args) {
        // imperative style
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println("-----------------");
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("-----------------");
        IntStream.range(0,5)
                .forEach(System.out::println);
        System.out.println("-----------------");
        IntStream.rangeClosed(0,5)
                .forEach(System.out::println);

        /*
         *    4 Functional Interfaces of java
         *  Supplier, Consumer, Predicate, Function
         */
        System.out.println("-----------------");
        // Java 9
        // iterate(seed, [predicate,], function)
        // predicate optional
        IntStream.iterate(0, i-> i<=15, i->i+3)
                .forEach(System.out::println);
        System.out.println("-----------------");
        IntStream.iterate(0, i->i+3)
                .takeWhile(i -> i <= 20)
                .forEach(System.out::println);

    }
}
