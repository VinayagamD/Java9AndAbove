package com.javatraining.corejavatraining.java8java9java10;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Java8Demo {
    public static void main(String[] args) {
        /*
        * Java 8 Feature lambda expression -> declarative style
        *  () -> {}
        *
        *  () lambda parameters
        *  -> lambda operators
        *  {} lambda body
        *
        *  default java 8 -> interface
        */
        /*
            Functional Interface with only method is called functional interface
                -> public or protected

            Java

            Supplier                    -> Supply the values
            Consumer -> BiConsumer      -> Consumer Consume the values
            Function -> BiFunction      -> Conversion of the values
            Predicate -> BiPredicate    -> Returns boolean hence predictions
         */

        Supplier<String> stringSupplier = () -> "Supplier";
        Supplier<String> stringSupplier2 = () -> {
            return "Supplier";
        };

        // Java 8 Functional

        Supplier<Double> doubleSupplier = Math::random; // :: reference operator
        Supplier<Double> doubleSupplier2 = () -> Math.random();
        System.out.println(stringSupplier.get());
        System.out.println(doubleSupplier.get());
        Consumer<String> stringConsumer = System.out::println;
        Consumer<Double> doubleConsumer = System.out::println;
        Consumer<String> stringConsumer2 = (s) -> System.out.println(s);
        stringConsumer.accept(stringSupplier.get());
        doubleConsumer.accept(doubleSupplier.get());
        Function<String,Integer> stringIntegerFunction = (s) -> s.length();
        Function<String,Integer> stringIntegerFunction2 = String::length;
        Function<String,String> stringToUpperFunction = String::toUpperCase;
        System.out.println(stringIntegerFunction.apply(stringSupplier.get()));
        System.out.println(stringToUpperFunction.apply(stringSupplier.get()));
        Predicate<String> evenStringPredicate = (s) -> s.length() % 2 == 0;
        System.out.println(evenStringPredicate.test(stringSupplier.get()));

        // Combining functional interface
        Consumer<Boolean> intDataConsumer = System.out::println;
        Supplier<String> stringDataSupplier = () -> "StringData";
        Function<String,Integer> stringDataFunction = String::length;
        Predicate<Integer> stringDataPredicate = (i) -> i % 2 == 0;

       intDataConsumer.accept(stringDataPredicate.test(stringDataFunction.apply(stringDataSupplier.get())));
       // Imperative Style
       for (int i = 1; i <= 10 ; i++) {
            if(i %2  != 0){
                System.out.println(i);
            }
        }

       // Declarative style
        IntStream.rangeClosed(1,10).filter(i -> i%2 != 0).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1,10).filter(i -> i%2 != 0).forEach(i -> System.out.print(i+"\t"));
        System.out.println();
        System.out.println(IntStream.rangeClosed(1,10).map(i -> i*2).sum());
        System.out.println(IntStream.rangeClosed(1,10).filter(i -> i == 5).findAny().orElse(0));
        System.out.println(IntStream.rangeClosed(1,4).filter(i -> i == 5).findAny().orElse(0));
    }
}
