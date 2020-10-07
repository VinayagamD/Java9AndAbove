package com.vinaylogics.designpattern.creational.abstract_factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class DefaultCarFactory {

    private DefaultCarFactory(){}

    static Car buildCar(CarType model){
        Car car = null;
        switch (model){
            case MINI:
                car = new MiniCar(Location.DEFAULT);
                break;
            case MICRO:
                car = new MicroCar(Location.DEFAULT);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.DEFAULT);
                break;
            default:
                throw new FactoryException("Invalid Car Model");
        }

        return car;
    }
}
