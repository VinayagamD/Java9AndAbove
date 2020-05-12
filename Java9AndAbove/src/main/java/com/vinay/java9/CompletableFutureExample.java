package com.vinay.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // deadlocks

        // livelocks

//        List<Integer> numbers = Arrays.asList(1,2,3);
        List<Integer> numbers = List.of(1,2,3);
        System.out.println(numbers);
//        numbers.set(0,4);
        System.out.println(numbers);
        System.out.println(Set.of("Tom", "Jerry"));
        System.out.println(Map.of("a",1, "b", 2, "c", 3, 5, "z"));
        // Fixed Type Inference
        Map<String, Integer> map = Map.of("a",1, "b", 2, "c", 3,  "z", 5);
        System.out.println(Map.<String,Integer>of("a",1, "b", 2, "c", 3,  "z", 5));
    }
}
