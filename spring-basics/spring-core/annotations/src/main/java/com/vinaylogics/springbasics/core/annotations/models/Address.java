package com.vinaylogics.springbasics.core.annotations.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

public class Address {

    @Autowired
    private List<String> addressList;
    @Autowired
    private Set<String> addressSet;
    @Autowired
    private Map<String,String > addressMap;
    @Autowired
    @Qualifier("getStringProperties")
    private Properties addressProp;
    @Autowired
    @Qualifier("name")
    private String name;
    @Autowired
    @Qualifier("nullName")
    private String nullName;

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public Set<String> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<String> addressSet) {
        this.addressSet = addressSet;
    }

    public Map<String, String> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, String> addressMap) {
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNullName() {
        return nullName;
    }

    public void setNullName(String nullName) {
        this.nullName = nullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressList, address.addressList) &&
                Objects.equals(addressSet, address.addressSet) &&
                Objects.equals(addressMap, address.addressMap) &&
                Objects.equals(addressProp, address.addressProp) &&
                Objects.equals(name, address.name) &&
                Objects.equals(nullName, address.nullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressList, addressSet, addressMap, addressProp, name, nullName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressList=" + addressList +
                ", addressSet=" + addressSet +
                ", addressMap=" + addressMap +
                ", addressProp=" + addressProp +
                ", name='" + name + '\'' +
                ", nullName='" + nullName + '\'' +
                '}';
    }
}
