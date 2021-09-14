package com.vinaylogics.corejavatraining.packages.demo.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestRuntime {

    public static void main(String[] args) throws IOException {
       Process process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "dir"});
        // starting the process


        // for reading the output from stream
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));
        String s;
        while ((s = stdInput.readLine()) != null)
        {
            System.out.println(s);
        }
    }
}
