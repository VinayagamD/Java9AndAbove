package com.javatraining.corejavatraining.oops_basics.encapsulation.test;

import com.javatraining.corejavatraining.oops_basics.encapsulation.MyDataDTO;

public class TestEncapsulation {

    public static void main(String[] args) {
        MyDataDTO myDataDTO = new MyDataDTO();
        myDataDTO.setId(0L);
        System.out.println(myDataDTO.getName());
    }
}
