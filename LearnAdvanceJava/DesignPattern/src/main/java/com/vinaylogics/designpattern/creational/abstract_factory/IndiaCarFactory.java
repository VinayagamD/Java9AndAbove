package com.vinaylogics.designpattern.creational.abstract_factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class IndiaCarFactory {

    private IndiaCarFactory(){}

    static Car buildCar(CarType model){

        return switch (model) {
            case MINI -> new MiniCar(Location.INDIA);
            case MICRO -> new MicroCar(Location.INDIA);
            case LUXURY -> new LuxuryCar(Location.INDIA);
        };
    }
}
