package com.vinaylogics.springbasics.core.xml;

import java.util.Objects;

public class Store {

    Item item;

    public Store() {
        System.out.println("Non Injection Constructor");
    }

    public Store(Item item) {
        System.out.println("Injection Constructor");
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(item, store.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "Store{" +
                "item=" + item +
                '}';
    }
}
