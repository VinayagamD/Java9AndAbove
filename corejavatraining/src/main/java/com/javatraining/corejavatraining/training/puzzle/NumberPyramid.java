package com.javatraining.corejavatraining.training.puzzle;

import java.util.Scanner;

public class NumberPyramid {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any number");
		int n = scanner.nextInt();
		if(n > 9) {
			System.out.println("Even number or greater than 10 piramid pattern will not appear proper pyramid pattern there will shift ");
		} 
		// loop the rows
		for (int i = 1; i <= n; i++) {
			int spaces = 0;
			// loop the spaces
			for(int j = 0; j < n-i ; j ++) {
				System.out.print("  ");
				spaces++;
			}
			int initalizer = n - spaces;
			int temporary = n - spaces;
			boolean reached1 = false;
			// print numbers
			for(int k = 1; k <=(1+(2*(i-1))); k++){
				if(initalizer == 1) {
					System.out.print(initalizer);
				}else {
					
					System.out.print((temporary)+" ");
					if (temporary == 1 || reached1) {
						reached1 = true; 
						temporary ++;
					}
					else
						temporary--;
				}
			}
			// next row
			System.out.println();
		}
	}

}
