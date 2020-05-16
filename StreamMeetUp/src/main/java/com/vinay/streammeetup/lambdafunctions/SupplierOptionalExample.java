package com.vinay.streammeetup.lambdafunctions;

import java.util.Optional;
import java.util.function.Supplier;

public class SupplierOptionalExample {
    public static void main(String[] args) {
        Supplier<Double> doubleSupplier = () -> Math.random();
        Optional<Double> optionalDouble = Optional.empty();
        System.out.println(optionalDouble.orElseGet(doubleSupplier));
    }
}
