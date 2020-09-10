package com.javatraining.corejavatraining.process;

import java.util.ArrayList;
import java.util.List;

public class ProcessDemo {
	
	public static void main(String[] args) {
		// creating list of process 
        List<String> list = new ArrayList<>(); 
        list.add("notepad.exe");
        list.add("abc.txt");
          
        // create the process 
        // ProcessBuilder build = new ProcessBuilder(list);
        ProcessBuilder build = new ProcessBuilder("notepad.exe", "abc.txt"); 
          
        // checking the command i list 
        System.out.println("command: " + build.command()); 
          

	}

}
