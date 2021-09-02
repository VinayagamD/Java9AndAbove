package com.vinaylogics.corejavatraining.fundamentals.demo.user_input;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
		String message = scanner.nextLine();
		System.out.println(message);
		scanner.close();
	}
}
