package com.vinay.streammeetup.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProperties {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> doubled = new ArrayList<>();
        System.out.println("-----------------------Functional Style----------------------------");
        Stream<Integer> integerStream = numbers.stream();
        doubled = integerStream.filter(e -> e % 2 == 0).map(e -> e * 2).collect(Collectors.toList());
        System.out.println(doubled);
        // two times stream will not work
        doubled = integerStream.filter(e -> e % 2 == 0).map(e -> e * 2).collect(Collectors.toList());
        System.out.println(doubled);
    }
}
