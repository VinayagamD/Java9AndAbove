package com.vinaylogics.springbaiscs.springcorexml.model;

public class Store {
    private Item item;

    public Store(Item item) {
        this.item = item;
    }

    public Store() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
