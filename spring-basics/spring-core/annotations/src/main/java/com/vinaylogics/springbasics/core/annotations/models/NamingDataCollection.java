package com.vinaylogics.springbasics.core.annotations.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class NamingDataCollection {

    @Autowired(required = false)
    private List<NamingData> namingDataList = new ArrayList<>();

    public List<NamingData> getNamingDataList() {
        System.out.println("Get Naming Data List "+ namingDataList);
        return namingDataList;
    }
}
