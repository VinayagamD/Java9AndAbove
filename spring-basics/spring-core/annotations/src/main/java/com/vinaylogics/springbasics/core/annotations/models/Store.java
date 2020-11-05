package com.vinaylogics.springbasics.core.annotations.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Objects;

public class Store {

    @Autowired
    @Qualifier("item")
    private Item item;

    public Store(Item item) {
        System.out.println("With Constructor DI");
        this.item = item;
    }

    public Store() {
        System.out.println("Without DI");
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        System.out.println("Setter DI");
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
