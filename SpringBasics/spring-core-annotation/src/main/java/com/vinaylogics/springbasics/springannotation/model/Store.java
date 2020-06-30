package com.vinaylogics.springbasics.springannotation.model;

public class Store {

    private Item item;



    public Store(Item item) {
        this.item = item;
    }

    public Store() {
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
