package com.vinaylogics.corejava.threads.basics.synchronize;

import java.util.ArrayList;
import java.util.List;

public class BlockSynchronizeDemo {

    public static void main(String[] args) {
        Geek gk = new Geek();
        List<String> list = new ArrayList<>();
        gk.geekName("vinay", list);
        System.out.println(gk.name);

    }

    public static class Geek {

        String name = "";
        public int count = 0;

        public void geekName(String geek, List<String> list){
            // Only one thread is permitted
            // to change geek's name at a time.
            synchronized(this)
            {
                name = geek;
                count++;  // how many threads change geek's name.
            }

            // All other threads are permitted
            // to add geek name into list.
            list.add(geek);
        }
    }
}
