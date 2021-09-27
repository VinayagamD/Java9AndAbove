package com.vinaylogics.corejavatraining.packages.demo.enums;

import java.util.Arrays;

public class EnumDemo {
	public static void main(String[] args) {
		Color r1 = Color.RED;
		System.out.println(r1);
		System.out.println(Color.RED.ordinal());
		System.out.println(Color.valueOf("RED"));
		switch (r1) {
		case RED:
			System.out.println("Choose RED");
			break;
		case YELLOW:
			System.out.println("Choose Yellow");
			break;
		default:
			System.out.println("Choose Pink");

			break;
		}

		switch (r1) {
			case RED -> System.out.println("Choose RED");
			case YELLOW -> System.out.println("Choose Yellow");
			default -> System.out.println("Choose Pink");
		}
		Color[] colors = Color.values();
		for (Color color : colors) {
			System.out.print(color+"\t");
		}
		System.out.println();
		Arrays.stream(Color.values()).forEach(System.out::println);
		Arrays.stream(Color.values()).forEach(color -> {
			System.out.println(color.ordinal());
		});
		Arrays.stream(Color.values()).forEach(color -> {
			System.out.println(color.name());
		});
		System.out.println(Color.valueOf("RED"));

	}
}
