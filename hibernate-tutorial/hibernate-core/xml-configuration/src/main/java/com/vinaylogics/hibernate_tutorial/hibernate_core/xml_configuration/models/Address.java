package com.vinaylogics.hibernate_tutorial.hibernate_core.xml_configuration.models;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private static final long serialVersionUID = 4606574325582978329L;
    private String city;
    private String country;
    private int pinCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return pinCode == address.pinCode &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, pinCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pinCode +
                '}';
    }
}
