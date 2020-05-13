package com.vinay.java11;

import java.util.List;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public class PredicatesJava11Example {
    public static void main(String[] args) {
        var numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
        System.out.println("-----------");
        numbers.stream()
                .filter(PredicatesJava11Example::isEven)
                .forEach(System.out::println);
        System.out.println("-----------------");
        numbers.stream()
                .filter(((Predicate<Integer>) (e -> e % 2 == 0)).negate())
                .forEach(System.out::println);
        System.out.println("-----------");
        numbers.stream()
                .filter(((Predicate<Integer>)PredicatesJava11Example::isEven).negate())
                .forEach(System.out::println);
        System.out.println("-----------------");
        numbers.stream()
                .filter(not(e -> e % 2 == 0))
                .forEach(System.out::println);
        System.out.println("-----------");
        numbers.stream()
                .filter(not(PredicatesJava11Example::isEven))
                .forEach(System.out::println);
    }

    private static boolean isEven(int n) {
        return n %2  == 0;
    }
}
