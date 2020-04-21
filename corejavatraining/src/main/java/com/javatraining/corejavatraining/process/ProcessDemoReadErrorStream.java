package com.javatraining.corejavatraining.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProcessDemoReadErrorStream {
	
	public static void main(String[] args) {
        // creating list of commands 
       List list = new ArrayList(); 
         
       list.add("notepad.exe"); 
       list.add("xyz.txt"); 
         
       //creating the process  
       ProcessBuilder build = new ProcessBuilder(list); 
       // redirecting error stream 
       build.redirectErrorStream(true); 

         
       // checking if error stream is redirected 
       System.out.println(build.redirectErrorStream()); 

	}
}
