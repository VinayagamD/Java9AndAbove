package com.vinay.java8streamsvsreactivestream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        // double of even numbers
        // Imperative style
        System.out.println("--------------------Imperative Style -------------------------");
        List<Integer> doubled = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i)%2 ==0){
                doubled.add(numbers.get(i)*2);
            }
        }
        System.out.println(doubled);
        // Functional Style
        // Declarative & function: code reads like the problem statement
        System.out.println("-----------------------Functional Style----------------------------");
        // Single pass through
        doubled = numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2).collect(Collectors.toList());
        System.out.println(doubled);

        /*
        *   Michael Feather:
        *   "In OOP we encapsulate the moving parts; in FP eliminates the moving parts"
        *
        * imperative style == tell me what and tell me how
        * declarative == tell me what and *not* how
        *
        * functional == declarative + higher order function
        *
        * external iteration vs internal iterations
        *
        * imperative style is inherently complex
        * */
    }
}
