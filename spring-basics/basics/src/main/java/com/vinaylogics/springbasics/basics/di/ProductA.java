package com.vinaylogics.springbasics.basics.di;

public class ProductA implements MultiProduct{
    @Override
    public String returnProductName() {
        return "ProductA";
    }
}
