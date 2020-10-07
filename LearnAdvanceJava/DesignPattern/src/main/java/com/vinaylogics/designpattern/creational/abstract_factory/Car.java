package com.vinaylogics.designpattern.creational.abstract_factory;

public abstract class Car {

    CarType model = null;
    Location location = null;

    public Car(CarType model, Location location) {
        this.model = model;
        this.location = location;
    }

    abstract protected void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Car Model=" + model +
                ", Located in =" + location +
                '}';
    }
}
