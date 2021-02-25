package com.vinaylogics.designpattern.creational.factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class VehicleFactory {
    /*public static final VehicleFactory INSTANCE = new VehicleFactory();*/

    private VehicleFactory() { }

    public enum Type{
        TWO, THREE, FOUR
    }

    public static Vehicle produceVehicle(Type type) throws FactoryException {
        if(type == null){
            throw new FactoryException("Null Vehicle type Not acceptable");
        }
        return switch (type) {
            case TWO -> new TwoWheeler();
            case THREE -> new ThreeWheeler();
            case FOUR -> new FourWheeler();
        };
    }

}
