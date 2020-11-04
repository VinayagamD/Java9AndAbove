package com.vinaylogics.springbasics.core.xml;

import java.util.*;

public class Address {

    private List<String> addressList;
    private Set<String> addressSet;
    private Map<String, String> addressMap;
    private Properties properties;
    private String name;
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

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
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
                Objects.equals(properties, address.properties) &&
                Objects.equals(name, address.name) &&
                Objects.equals(nullName, address.nullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressList, addressSet, addressMap, properties, name, nullName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressList=" + addressList +
                ", addressSet=" + addressSet +
                ", addressMap=" + addressMap +
                ", properties=" + properties +
                ", name='" + name + '\'' +
                ", nullName='" + nullName + '\'' +
                '}';
    }
}
