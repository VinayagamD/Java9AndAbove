package com.vinaylogics.springbasics.springannotation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class StoreAuto {

    @Autowired
    private Item item;

    @Autowired()
    @Qualifier("item")
    private Item itemName;

    public Item getItem() {
        return item;
    }

    public Item getItemName() {
        return itemName;
    }
}
