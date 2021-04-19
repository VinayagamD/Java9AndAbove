package com.javatraining.corejavatraining.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class StringArrayExample {
	
	public static void main(String[] args) {
		String[] arrays = new String[10];
		arrays[9] = "Hello";
//		System.out.println(arrays[-1]);
//		System.out.println(arrays[10]);
		for (int i = 0; i < arrays.length; i++) {
			System.out.println(arrays[i]);
		}
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = String.valueOf(i);
		}
		for (int i = 0; i < arrays.length; i++) {
			System.out.println(arrays[i]);
		}
		System.out.println();
		//Enhanced For Loop
		for (String data : arrays) {
			System.out.println(data);
		}
		String [] arrays2  = arrays.clone();
		System.out.println("================ Clone Start ================");
		for (String string : arrays2) {
			System.out.println(string);
		}
		System.out.println("================= Clone End ===================");
		System.out.println("Copied "+arrays2.length);
// 		arrays2 = new String[arrays2.length*2];
//		for (int i = 0; i < arrays.length; i++) {
//			arrays2[i] = arrays[i];
//		}
		arrays2 = Arrays.copyOf(arrays2, arrays2.length *2);
		System.out.println("Copied Increased length"+arrays2.length);

		System.out.println("================ Clone Start ================");
		for (String string : arrays2) {
			System.out.println(string);
		}
		System.out.println("================= Clone End ===================");

		System.out.println("Java 8");
		Arrays.asList(arrays).forEach(System.out::println);

		varargs(  1,2, 3,4,5,6,7,8,9, 10);
		varargs();
		varargs2(new int[]{});
//		varargs2();
		/*Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			if(scanner.nextLine().equals("q")) {
				break;
			}
		}*/
		
	}

	public static  void varargs(int ... variant) {
		System.out.println("================ Varargs ================");
		for (int i = 0; i < variant.length; i++) {
			System.out.println(variant[i]);
		}
	}
	public static  void varargs2(int [] variant ) {
		System.out.println("================ Varargs2 ================");
		for (int i = 0; i < variant.length; i++) {
			System.out.println(variant[i]);
		}
	}
//	public static void varargsCondition(String a,int... variant){}
//	public static void varargsCondition(int... variant, String a){}
//	public static void varargsCondition(int... variant, String... a){}
//	public static void varargsCondition(int... variant, int... a){}


}
