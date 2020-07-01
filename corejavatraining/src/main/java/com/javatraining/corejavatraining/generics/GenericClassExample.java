package com.javatraining.corejavatraining.generics;

import java.util.ArrayList;

public class GenericClassExample {
	
	public static void main(String[] args) {
		GenericClass<String> genericClass = new GenericClass<>("Object");
		 String test =  genericClass.getT();
		 System.out.println(test);
		 System.out.println(test);
		 ArrayList<String> genralList = new ArrayList<>();
		 genralList.add("Hello");
//		 genralList.add(10);
		 System.out.println((String)genralList.get(0));
//		 System.out.println((String)genralList.get(1));
	}

}
