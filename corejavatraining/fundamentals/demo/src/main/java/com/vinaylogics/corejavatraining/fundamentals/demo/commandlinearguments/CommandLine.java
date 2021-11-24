/**
 * 
 */
package com.vinaylogics.corejavatraining.fundamentals.demo.commandlinearguments;

/**
 * @author vinay
 *
 */
public class CommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (String string : args) {
            System.out.println(string);
        }

		String str1 = args[0];
		String str2 = args[1];
		String str3 = args[2];
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		int data = Integer.parseInt(str3);
		System.out.println(data);
	}

}
