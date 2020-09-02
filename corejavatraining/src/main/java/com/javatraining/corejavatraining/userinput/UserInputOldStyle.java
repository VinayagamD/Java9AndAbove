package com.javatraining.corejavatraining.userinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class UserInputOldStyle {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		String line;
		
		while((line = bufferedReader.readLine()) != null ) {
			if(line.equals("exit") || line.equals("")) {
				break;
			}
			System.out.println(line);
		}
	}
}
