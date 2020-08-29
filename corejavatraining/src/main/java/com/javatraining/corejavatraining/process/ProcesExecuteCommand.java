package com.javatraining.corejavatraining.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcesExecuteCommand {
	public static void main(String[] args) throws IOException {
		// creating list of commands  
        List<String> commands = new ArrayList<>();
        commands.add("cmd.exe");
        commands.add("/c");
        commands.add("dir"); // command 
 
          
        // creating the process 
        ProcessBuilder pb = new ProcessBuilder(commands); 
          
        // startinf the process 
        Process process = pb.start(); 
          
        // for reading the ouput from stream 
        BufferedReader stdInput = new BufferedReader(new
         InputStreamReader(process.getInputStream())); 
        String s = null; 
        while ((s = stdInput.readLine()) != null) 
        { 
            System.out.println(s); 
        } 

	}
}
