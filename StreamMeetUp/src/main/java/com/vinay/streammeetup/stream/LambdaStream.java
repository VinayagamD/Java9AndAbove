package com.vinay.streammeetup.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("--------------------Imperative Style -------------------------");
        List<Integer> doubled = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i)%2 ==0){
                doubled.add(numbers.get(i)*2);
            }
        }
        System.out.println(doubled);

        System.out.println("-----------------------Functional Style----------------------------");
        doubled = numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2).collect(Collectors.toList());
        System.out.println(doubled);

        /*doubled = numbers.parallelStream().filter(e -> e % 2 == 0).map(e -> e * 2).collect(Collectors.toList());
        System.out.println(doubled);*/
    }
}
