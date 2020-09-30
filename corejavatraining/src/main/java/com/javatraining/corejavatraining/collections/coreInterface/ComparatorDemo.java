package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<DemoBook> listOfBooks = new ArrayList<>();
        listOfBooks.add(new DemoBook("Effective Java", "Joshua Bloch", 32));
        listOfBooks.add(new DemoBook("Java Puzzlers", "Joshua Bloch", 22));
        listOfBooks.add(new DemoBook("Java Concurrency in Practice", "Brian Goetz", 42));
        listOfBooks.add(new DemoBook("Java SE 8 for Really Impatient", "Cay S. Horstmann", 34));
        listOfBooks.add(new DemoBook("Core Java", "Cay S. Horstmann",32));
        Comparator<DemoBook> byAuthor = Comparator.comparing(DemoBook::getAuthor);
        listOfBooks.sort(byAuthor);
        System.out.println("list of books after sorting: " + listOfBooks);
        Comparator<DemoBook> byTitle = Comparator.comparing(DemoBook::getTitle);
        Comparator<DemoBook> byPrice = Comparator.comparing(DemoBook::getPrice);
        listOfBooks.sort(byTitle);
        System.out.println("list of books after sorting: " + listOfBooks);
        listOfBooks.sort(byPrice);
        System.out.println("list of books after sorting: " + listOfBooks);
    }
}
