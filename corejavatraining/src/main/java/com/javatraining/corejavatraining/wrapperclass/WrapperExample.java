package com.javatraining.corejavatraining.wrapperclass;

public class WrapperExample {
	
	public static void main(String[] args) {
		// Auto boxing
		Integer integer = 10; // int
		System.out.println(integer);
		Integer integerFromString = Integer.parseInt("10");
		System.out.println(integerFromString);
		// Unboxing
		int int1 = integer;
		int int2 = integerFromString;
		System.out.println(int1);
		System.out.println(int2);
//		Compilation Error This case not possible
//		Integer errorInt = 10L;
//		Long longData = 10;
	}

}
