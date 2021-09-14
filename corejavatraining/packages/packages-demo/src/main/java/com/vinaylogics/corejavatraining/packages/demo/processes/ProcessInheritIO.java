package com.vinaylogics.corejavatraining.packages.demo.processes;

import java.io.IOException;

public class ProcessInheritIO {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder 
                ( "cmd.exe", "/c", "echo", "Hello GeeksforGeeksThis is ProcessBuilder Example"); 
        pb.inheritIO(); 
        Process process = pb.start(); 
        process.waitFor();
	}
}
