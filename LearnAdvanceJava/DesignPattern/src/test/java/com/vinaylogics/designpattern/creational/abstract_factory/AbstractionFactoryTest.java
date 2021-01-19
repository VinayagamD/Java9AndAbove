package com.vinaylogics.designpattern.creational.abstract_factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class AbstractionFactoryTest {

    @ParameterizedTest(name= "Valid test type {0}")
    @EnumSource(value = CarType.class, names = {"MINI", "MICRO", "LUXURY"})
    public void testAbstractFactory(CarType carType){
        System.out.println(CarFactory.buildCar(carType));
    }

}