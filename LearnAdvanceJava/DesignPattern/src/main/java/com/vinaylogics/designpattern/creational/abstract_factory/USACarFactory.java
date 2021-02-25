package com.vinaylogics.designpattern.creational.abstract_factory;

public final class USACarFactory {

    private USACarFactory(){}

    static Car buildCar(CarType model){
        return switch (model) {
            case MINI -> new MiniCar(Location.USA);
            case MICRO -> new MicroCar(Location.USA);
            case LUXURY -> new LuxuryCar(Location.USA);
        };
    }
}
