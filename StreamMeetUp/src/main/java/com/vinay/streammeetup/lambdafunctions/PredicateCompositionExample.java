package com.vinay.streammeetup.lambdafunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateCompositionExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Smith","Sye", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        Predicate<String> nameEndsWithWithE = str -> str.endsWith("e");
        names.stream().filter(nameStartsWithS.and(nameEndsWithWithE)).forEach(System.out::println);
        names.stream().filter(nameStartsWithS.or(nameEndsWithWithE)).forEach(System.out::println);

    }
}
