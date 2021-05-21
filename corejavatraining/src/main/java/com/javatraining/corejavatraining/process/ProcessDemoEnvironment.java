package com.javatraining.corejavatraining.process;

import java.util.Map;

public class ProcessDemoEnvironment {
	
	public static void main(String[] args) {
        // creating the process 
        ProcessBuilder pb = new ProcessBuilder(); 
          
        // map view of this process builder's environment 
        Map<String, String> envMap = pb.environment(); 
          
        // checking map view of environment 
        for(Map.Entry<String, String> entry : envMap.entrySet())
        {    
             // checking key and value separately 
            System.out.println("Key = " + entry.getKey() +  
               ", Value = " + entry.getValue()); 
        }
        // () -> {}

        System.out.println("======================= Java 8 =======================");
        envMap.forEach((key, value) -> System.out.println("Key = " + key + ", Value = " + value));

        System.out.println("================ Method Reference ===================");
        envMap.values().forEach(System.out::println);
        envMap.keySet().forEach(System.out::println);
	}
}
