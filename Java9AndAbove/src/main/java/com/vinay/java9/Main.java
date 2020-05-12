package com.vinay.java9;

 interface Util {
    default int getNumberOfCore() {
        return getCount();
    }

    static int getNumberOfCore2() { return getCount2();}

    private int getCount() { return 4;}
    private static int getCount2() {return 4;}
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("ok");
        System.out.println(Util.getNumberOfCore2());
    }
}
