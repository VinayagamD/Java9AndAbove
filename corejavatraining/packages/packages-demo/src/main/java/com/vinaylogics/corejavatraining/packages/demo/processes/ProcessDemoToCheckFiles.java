package com.vinaylogics.corejavatraining.packages.demo.processes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProcessDemoToCheckFiles {

	public static void main(String[] args) {
		// creating list of process 
        List<String> list = new ArrayList<>(); 
        list.add("notepad.exe");
        list.add("abc.txt");
          
        // create the process 
//        ProcessBuilder build = new ProcessBuilder(list); 
        ProcessBuilder build = new ProcessBuilder(list);
        build.directory(new File("src"));
        
          
        // checking the command i list 
        System.out.println("directory: " + build.directory()); 
	}
	
}
