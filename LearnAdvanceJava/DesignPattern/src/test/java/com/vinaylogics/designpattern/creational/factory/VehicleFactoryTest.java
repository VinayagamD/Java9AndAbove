package com.vinaylogics.designpattern.creational.factory;

import com.vinaylogics.designpattern.exception.FactoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    @ParameterizedTest(name= "Valid test type {0}")
    @EnumSource(value = VehicleFactory.Type.class, names = {"TWO", "THREE", "FOUR"})
    void testProduceVehicle_ValidTypes(VehicleFactory.Type type) {
        Vehicle vehicle = VehicleFactory.produceVehicle(type);
        switch (type) {
            case TWO -> assertTrue(vehicle instanceof TwoWheeler);
            case THREE -> assertTrue(vehicle instanceof ThreeWheeler);
            case FOUR -> assertTrue(vehicle instanceof FourWheeler);
        }
    }

    @Test
    @DisplayName("Invalid test case for factory creation")
    void  testProductVehicle_InvalidTypesNull(){
        try {
            VehicleFactory.produceVehicle(null);
            fail("Expecting Factory Exception Success");
        }catch (FactoryException e){
            assertNotNull(e);
            assertEquals( "Null Vehicle type Not acceptable",e.getMessage());
        }
    }
}