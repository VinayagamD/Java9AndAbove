package com.vinay.java11;


import java.util.List;

public class Iterations {

    public static void main(String[] args) {
        var numbers = List.of(1,2,3);
        numbers.forEach((Integer e) -> System.out.println(e));
        System.out.println("----------");
        numbers.forEach(e -> System.out.println(e));
        System.out.println("----------");
        numbers.forEach(( Integer e) -> System.out.println(e));
        System.out.println("----------");
//        numbers.forEach(( final e) -> System.out.println(e));
        // Either say type and use annotation or leave them both out
        numbers.forEach(( final var e) -> System.out.println(e));
        // use annotation with type or with var

    }
}
