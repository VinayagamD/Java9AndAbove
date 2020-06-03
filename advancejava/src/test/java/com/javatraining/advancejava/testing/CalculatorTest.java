/**
 * 
 */
package com.javatraining.advancejava.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author vinay
 * This method tests for
 * @see com.javatraining.advancejava.testing.Calculator
 *
 */
public class CalculatorTest {

	private Calculator calculator;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}



	/**
	 * Test method for {@link com.javatraining.advancejava.testing.Calculator#add(int, int)}.
	 */
	@Test
	public void testAdd_Success() {
		int a = 3;
		int b = 4;
		int expected = a+b;
		int actual = calculator.add(a, b);
		assertEquals(expected, actual);
		
	}

	/**
	 * Test method for {@link com.javatraining.advancejava.testing.Calculator#sub(int, int)}.
	 */
	@Test
	public void testSub_Success() {
		int a = 3;
		int b = 4;
		int expected = a-b;
		int actual = calculator.sub(a, b);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.javatraining.advancejava.testing.Calculator#multiply(int, int)}.
	 */
	@Test
	public void testMultiply_Success() {
		int a = 3;
		int b = 4;
		int expected = a*b;
		int actual = calculator.multiply(a, b);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.javatraining.advancejava.testing.Calculator#division(int, int)}.
	 */
	@Test
	public void testDivision_Success() {
		int a = 12;
		int b = 4;
		int expected = a/b;
		int actual = calculator.division(a, b);
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link com.javatraining.advancejava.testing.Calculator#division(int, int)}.
	 */
	@Test
	public void testDivision_DivideByZero() {
		int a = 12;
		int b = 0;
		try {
			calculator.division(a, b);
			fail("Expected Exception");
		}catch (ArithmeticException e) {
			assertNotNull(e);
		}
	}

}
