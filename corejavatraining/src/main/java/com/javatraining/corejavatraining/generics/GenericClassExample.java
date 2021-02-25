package com.javatraining.corejavatraining.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericClassExample {
	
	public static void main(String[] args) {
		GenericClass<String> genericClass = new GenericClass<>("Object");
		 String test =  genericClass.getT();
		 System.out.println(test);
		 System.out.println(test);
//		 ArrayList generalList = new ArrayList();
		 ArrayList<String> generalList = new ArrayList<>();

		 generalList.add("Hello");
//		 generalList.add(10);
		 System.out.println(generalList.get(0));
//		 System.out.println((Integer) generalList.get(0));
	}

}
