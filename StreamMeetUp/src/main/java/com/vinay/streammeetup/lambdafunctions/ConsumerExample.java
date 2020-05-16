package com.vinay.streammeetup.lambdafunctions;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);

    }
}
