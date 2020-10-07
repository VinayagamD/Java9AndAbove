package com.vinaylogics.designpattern.creational.abstract_factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class IndiaCarFactory {

    private IndiaCarFactory(){}

    static Car buildCar(CarType model){
        Car car = null;
        switch (model){
            case MINI:
                car = new MiniCar(Location.INDIA);
                break;
            case MICRO:
                car = new MicroCar(Location.INDIA);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.INDIA);
                break;
            default:
                throw new FactoryException("Invalid Car Model");
        }

        return car;
    }
}
