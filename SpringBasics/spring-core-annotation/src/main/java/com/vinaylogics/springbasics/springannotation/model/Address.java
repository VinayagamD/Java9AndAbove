package com.vinaylogics.springbasics.springannotation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Address {

    @Autowired
    @Qualifier("listString")
    private List<String> addressList;
    @Autowired
    @Qualifier("setString")
    private Set<String> addressSet;
    @Autowired
    @Qualifier("mapString")
    private Map<String,String> addressMap;
    @Autowired
    @Qualifier("addressProps")
    private Properties addressProp;
    @Autowired
    private String name;
    @Autowired
    @Qualifier("nullName")
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
