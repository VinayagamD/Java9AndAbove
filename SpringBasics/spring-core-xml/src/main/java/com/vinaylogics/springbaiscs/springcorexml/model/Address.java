package com.vinaylogics.springbaiscs.springcorexml.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Address {

    private List<String> addressList;
    private Set<String> addressSet;
    private Map<String,String> addressMap;
    private Properties addressProp;
    private String name;
    private String nullName;

    public List<String> getAddressList() {
        System.out.println("Getter Address List "+ addressList);
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        System.out.println("Setter Address List "+ addressList);
        this.addressList = addressList;
    }

    public Set<String> getAddressSet() {
        System.out.println("Getter Address Set "+ addressSet);
        return addressSet;
    }

    public void setAddressSet(Set<String> addressSet) {
        System.out.println("Setter Address Set "+ addressSet);
        this.addressSet = addressSet;
    }

    public Map<String, String> getAddressMap() {
        System.out.println("Getter Address Map "+ addressMap);
        return addressMap;
    }

    public void setAddressMap(Map<String, String> addressMap) {
        System.out.println("Setter Address Map "+ addressMap);
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        System.out.println("Getter Address Prop "+ addressProp);
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        System.out.println("Setter Address Prop "+ addressProp);
        this.addressProp = addressProp;
    }

    public String getName() {
        System.out.println("Getter name "+name);
        return name;
    }

    public void setName(String name) {
        System.out.println("Setter name "+name);
        this.name = name;
    }

    public String getNullName() {
        System.out.println("Getter nullName "+nullName);
        return nullName;
    }

    public void setNullName(String nullName) {
        System.out.println("Setter nullName "+nullName);
        this.nullName = nullName;
    }
}
