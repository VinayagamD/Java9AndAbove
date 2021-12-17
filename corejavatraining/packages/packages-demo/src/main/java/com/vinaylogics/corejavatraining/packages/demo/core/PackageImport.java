package com.vinaylogics.corejavatraining.packages.demo.core;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class PackageImport {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        out.println(10);
        Test test = new Test();
        Test test1 = new Test();
        com.vinaylogics.corejavatraining.packages.demo.models.Test test2
                = new com.vinaylogics.corejavatraining.packages.demo.models.Test();
    }
}
