/**
 * 
 */
package com.vinaylogics.corejavatraining.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author vinay
 *
 */
public class ExceptionResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try(
				FileInputStream inputStream =new  FileInputStream("message.txt");
			Scanner scanner = new Scanner(inputStream);
//			Test test = new Test();
		/*
		 * BufferedInputStream bufferedInputStream = new
		 * BufferedInputStream(inputStream)
		 */){

			/*
			 * int data = bufferedInputStream.read(); while(data != -1){
			 * System.out.print((char) data); data = bufferedInputStream.read(); }
			 */
			System.out.println(scanner.nextLine());

			
		} catch ( FileNotFoundException  e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Always executed");
		}

	}

}
