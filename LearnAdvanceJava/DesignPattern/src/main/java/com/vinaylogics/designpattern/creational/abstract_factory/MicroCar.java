package com.vinaylogics.designpattern.creational.abstract_factory;

public class MicroCar extends Car {

    public MicroCar(Location location) {
        super(CarType.MICRO, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Connecting to micro car");
    }
}
