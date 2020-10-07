package com.vinaylogics.designpattern.creational.abstract_factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class USACarFactory {

    private USACarFactory(){}

    static Car buildCar(CarType model){
        Car car = null;
        switch (model){
            case MINI:
                car = new MiniCar(Location.USA);
                break;
            case MICRO:
                car = new MicroCar(Location.USA);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.USA);
                break;
            default:
                throw new FactoryException("Invalid Car Model");
        }

        return car;
    }
}
