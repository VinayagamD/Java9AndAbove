/**
 * 
 */
package com.vinaylogics.corejavatraining.exception;

/**
 * @author vinay
 *
 */
public class MyException extends Exception {
	
	private int exceptionCode;
	public MyException(int exceptionCode, String message) {
		super(message);
		this.exceptionCode = exceptionCode;
	}


	public int getExceptionCode() {
		return exceptionCode;
	}


	

}
