package com.javatraining.corejavatraining.collections.coreInterface;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class DemoBook implements Serializable, Comparable<DemoBook>{

    private static final long serialVersionUID = 7530876160055266984L;

    private String title;
    private String author;
    private int price;

    public DemoBook() {
    }

    public DemoBook(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoBook demoBook = (DemoBook) o;
        return price == demoBook.price &&
                Objects.equals(title, demoBook.title) &&
                Objects.equals(author, demoBook.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    @Override
    public String toString() {
        return "DemoBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(@NotNull DemoBook b) {
        int i = this.title.compareTo(b.title);
        if (i != 0)
            return i;
        i = this.author.compareTo(b.author);
        if (i != 0)
            return i;
        return Integer.compare(this.price, b.price);

    }
}
