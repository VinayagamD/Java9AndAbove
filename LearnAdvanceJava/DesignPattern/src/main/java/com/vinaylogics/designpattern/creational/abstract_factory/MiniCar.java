package com.vinaylogics.designpattern.creational.abstract_factory;

public class MiniCar extends Car {

    public MiniCar(Location location) {
        super(CarType.MICRO, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Connecting to mini car");
    }
}
