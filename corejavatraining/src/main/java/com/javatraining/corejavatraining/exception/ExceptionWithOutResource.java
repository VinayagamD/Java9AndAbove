/**
 * 
 */
package com.javatraining.corejavatraining.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author vinay
 *
 */
public class ExceptionWithOutResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream inputStream = null;
		Scanner scanner = null;
		try {

			/*
			 * int data = bufferedInputStream.read(); while(data != -1){
			 * System.out.print((char) data); data = bufferedInputStream.read(); }
			 */
			inputStream	 =new  FileInputStream("message.txt");
			scanner = new Scanner(inputStream);
			System.out.println(scanner.nextLine());

			
		} catch ( FileNotFoundException  e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(scanner != null){
				scanner.close();
			}
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Always executed");
		}

	}

}
