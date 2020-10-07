package com.vinaylogics.designpattern.creational.abstract_factory;

import com.vinaylogics.designpattern.exception.FactoryException;

public final class CarFactory {
    private CarFactory(){}

    public static Car buildCar(CarType type){
        Car car =  null;
        Location location = Location.INDIA;
        switch (location){
            case INDIA:
                car = IndiaCarFactory.buildCar(type);
                break;
            case USA:
                car = USACarFactory.buildCar(type);
                break;
            case DEFAULT:
                car = DefaultCarFactory.buildCar(type);
                break;
            default:
                throw new FactoryException("Invalid Car Type");
        }
        return car;
    }
}
