package com.vinaylogics.designpattern.creational.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    @DisplayName("Valid test case demo")
    @ParameterizedTest(name= "Valid test type {0}")
    @EnumSource(value = VehicleFactory.Type.class, names = {"TWO", "THREE", "FOUR"})
    void testProduceVehicle_ValidTypes(VehicleFactory.Type type) {
        Vehicle vehicle = VehicleFactory.produceVehicle(type);
        switch (type){
            case TWO:
                assertTrue(vehicle instanceof TwoWheeler);
                break;
            case THREE:
                assertTrue(vehicle instanceof ThreeWheeler);
                break;
            case FOUR:
                assertTrue(vehicle instanceof FourWheeler);
                break;
        }
    }
}