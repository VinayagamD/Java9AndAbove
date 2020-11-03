package com.vinaylogics.springbasics.basics.di;

public class ProductB implements MultiProduct {
    @Override
    public String returnProductName() {
        return "ProductB";
    }
}
