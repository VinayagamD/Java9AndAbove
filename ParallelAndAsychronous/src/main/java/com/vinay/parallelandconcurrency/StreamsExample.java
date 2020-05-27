package com.vinay.parallelandconcurrency;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {

    public static void main(String[] args) {
        // Martin Fowler: Collection Pipeline Pattern
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // find the total of double of even numbers
        // imperative style
        int total = 0;
        for(int e : numbers){
            if(e %2 == 0){
                total += e*2;
            }
        }
        System.out.println(total);
        // imperative style has accidental complexity


        // Functional Style - functional composition
        System.out.println(numbers.stream().filter(e -> e %2 == 0).mapToInt(e-> e *= 2).sum());
        // Functional Style has less complexity and is also easier to parallelize

        // multiple thread synchronize and suffer model
    }
}
