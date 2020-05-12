package com.vinay.java9;

import java.util.*;
import java.util.stream.*;

public class OptionalExample {


    // Please don't do this at home or office
    private static void process(Optional<Integer> result) {
//        System.out.println(result.get()); // Don't
//        System.out.println(result.orElseThrow());
        System.out.println(result.orElse(0));
        // Imperative style
        if(result.isPresent()){
            System.out.println("The value is " + result.get());
        }else {
            System.out.println("Nothing present");
        }

        // Functional style
        result.ifPresentOrElse(value -> System.out.println("Thew value is " + value),
                () -> System.out.println("No Value"));

        // Optional<T>                      Present             Absent
        // orElse(substitute)               T data              T substitute
        // or(()-> Optional.of(substitute)) Optional(data)      Optional(substitute)
    }

    public static void process(Stream<Integer> result){
        result.forEach(System.out::println);
    }

    // Use Optional<T> as a return and not as a parameter to a function,
    // except when giving to this talk. Instead use overloading
    public static void process(){}
    public static void process(int value){}

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        /*Optional<Integer> result1 = numbers.stream()
                .filter(e -> e > 5)
                .findFirst();

        Optional<Integer> result2 =  numbers.stream()
                .filter(e -> e > 50)
                .findFirst();

        System.out.println(result1);
        System.out.println(result2);*/
        process(numbers.stream()
                .filter(e -> e > 5)
                .findFirst());
        System.out.println("------");
        process(numbers.stream()
                        .filter(e -> e > 50)
                        .findFirst());
        System.out.println("------");
        process(numbers.stream().filter(e-> e > 5).findFirst().stream());
    }

}
