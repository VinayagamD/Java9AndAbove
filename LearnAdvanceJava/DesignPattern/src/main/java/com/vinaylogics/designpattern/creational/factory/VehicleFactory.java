package com.vinaylogics.designpattern.creational.factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class VehicleFactory {
    /*public static final VehicleFactory INSTANCE = new VehicleFactory();*/

    private VehicleFactory() { }

    public enum Type{
        TWO, THREE, FOUR
    }

    public static Vehicle produceVehicle(Type type) throws FactoryException {
        Vehicle vehicle;
        switch (type){
            case TWO:
                vehicle = new TwoWheeler();
                break;
            case THREE:
                vehicle = new ThreeWheeler();
                break;
            case FOUR:
                vehicle = new FourWheeler();
                break;
            default:
                throw new FactoryException("Invalid Vehicle type");
        }
        return vehicle;
    }

}
