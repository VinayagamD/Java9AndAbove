package com.vinaylogics.corejavatraining.fundamentals.demo.controlstructure;

public class IteratingCS {

    public static void main(String[] args) {
        System.out.println("======================== For Loop ===========================");
        checkForLoop();
        System.out.println("====================While Loop=====================");
        checkForWhileLoop();
        System.out.println("====================do While Loop=====================");
        checkDoWhileLoop();
    }

    private static void checkDoWhileLoop() {
        boolean queueAvailable = true;
        int i = 0;
        do {
            System.out.println(i);
            if (++i > 10) {
                queueAvailable = false;
            }
        } while (queueAvailable);
    }

    private static void checkForWhileLoop() {
        boolean queueAvailable = true;
        int i = 0;
        while (queueAvailable/* true*/) {
            System.out.println(i);
            if (++i > 10) {
                queueAvailable = false;
//                break;
            }
        }
    }

    private static void checkForLoop() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);
        }
    }
}
