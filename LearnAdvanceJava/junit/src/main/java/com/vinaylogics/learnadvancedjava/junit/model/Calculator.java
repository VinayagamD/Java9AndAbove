package com.vinaylogics.learnadvancedjava.junit.model;


/**
 * <a>com.javatraining.advancejava.testing.Calculator</a>
 * @version 1.0
 * @author vinay
 * 
 * @since 2020
 * <blockquote> This class for testing the Calculator class for demo purpose </blockquote>
 *
 */
public class Calculator {
	
	/**
	 * This method adds the two integer value
	 * @param a input1
	 * @param b input2
	 * @return sum of two input
	 */
	public int add(int a, int b) {
		return a + b;
	}
	
	/**
	 * This method subtracts the two integer value
	 * @param a input1
	 * @param b input2
	 * @return difference between two input
	 */
	public int sub(int a, int b) {
		return a - b;
	}
	
	/**
	 * This method multiply the two integer value
	 * @param a input1
	 * @param b input2
	 * @return product of two input
	 */
	public int multiply(int a, int b) {
		return a * b;
	}
	
	/**
	 * This method divides the two integer value
	 * @param a input1
	 * @param b input2
	 * @throws ArithmeticException : Input for denominator is zero
	 * {@link ArithmeticException}
	 * @return quotient of two input
	 */
	public int division(int a, int b) throws ArithmeticException{
		if(b == 0 ) {
			throw new ArithmeticException("b value cannot be zero");
		}
		return a / b;
	}

}
