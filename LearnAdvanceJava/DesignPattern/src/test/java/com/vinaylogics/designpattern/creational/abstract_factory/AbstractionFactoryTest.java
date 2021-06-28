package com.vinaylogics.designpattern.creational.abstract_factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class AbstractionFactoryTest {

    @ParameterizedTest(name= "Valid test type {0}")
    @EnumSource(value = CarType.class, names = {"MINI", "MICRO", "LUXURY"})
    public void testAbstractFactory(CarType carType){
        var car = CarFactory.buildCar(carType);
        System.out.println();
        switch (carType){
            case MINI -> assertTrue(car instanceof MiniCar);
            case MICRO -> assertTrue(car instanceof MicroCar);
            case LUXURY -> assertTrue(car instanceof LuxuryCar);
        }
    }

}