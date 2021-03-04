package com.vinaylogics.learnadvancejava.jdbc.basics.models;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {


    private static final long serialVersionUID = 7838743930175863519L;

    private Long id;
    private Long isbn;
    private String name;
    private Long authorId;
    private Long edNum;
    private Double price;
    private Integer pages;

    public Book() {
    }

    public Book(Builder builder) {
        this.id = builder.id;
        this.isbn = builder.isbn;
        this.name = builder.name;
        this.authorId = builder.authorId;
        this.edNum = builder.edNum;
        this.price = builder.price;
        this.pages = builder.pages;

    }

    public static Builder builder(){
        return new Builder();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getEdNum() {
        return edNum;
    }

    public void setEdNum(Long edNum) {
        this.edNum = edNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public static class Builder{
        private Long id;
        private Long isbn;
        private String name;
        private Long authorId;
        private Long edNum;
        private Double price;
        private Integer pages;

        private Builder(){
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setIsbn(Long isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAuthorId(Long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setEdNum(Long edNum) {
            this.edNum = edNum;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setPages(Integer pages) {
            this.pages = pages;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(isbn, book.isbn) && Objects.equals(name, book.name) && Objects.equals(authorId, book.authorId) && Objects.equals(edNum, book.edNum) && Objects.equals(price, book.price) && Objects.equals(pages, book.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, name, authorId, edNum, price, pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", edNum=" + edNum +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }
}
