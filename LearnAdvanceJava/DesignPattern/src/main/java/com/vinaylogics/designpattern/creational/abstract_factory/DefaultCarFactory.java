package com.vinaylogics.designpattern.creational.abstract_factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class DefaultCarFactory {

    private DefaultCarFactory(){}

    static Car buildCar(CarType model){

        return switch (model) {
            case MINI -> new MiniCar(Location.DEFAULT);
            case MICRO -> new MicroCar(Location.DEFAULT);
            case LUXURY -> new LuxuryCar(Location.DEFAULT);
        };
    }
}
