package com.vinaylogics.learnadvancedjava.cocurrentcollections.needforcollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentCollectionsNeed extends Thread{

    static List<String> l = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        l.add("A");
        l.add("B");
        l.add("C");
        // We create a child thread that is
        // going to modify ArrayList l.
        ConcurrentCollectionsNeed t = new ConcurrentCollectionsNeed();
        t.start();

        // Now we iterate through the ArrayList
        // and get exception.
        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            String s = (String)itr.next();
            System.out.println(s);
            Thread.sleep(6000);
        }
        System.out.println(l);

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Child Thread going to add element");
        }
        // Child thread trying to add new
        // element in the Collection object
        l.add("D");

    }
}
