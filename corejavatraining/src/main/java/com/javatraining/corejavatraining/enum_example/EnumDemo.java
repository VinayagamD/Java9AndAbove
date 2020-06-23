package com.javatraining.corejavatraining.enum_example;

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
		Color[] colors = Color.values();
		for (Color color : colors) {
			System.out.print(color+"\t");
		}
	}
}
