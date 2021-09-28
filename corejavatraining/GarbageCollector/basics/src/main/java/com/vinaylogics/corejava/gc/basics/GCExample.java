/**
 * 
 */
package com.vinaylogics.corejava.gc.basics;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.gc;
import static java.lang.System.runFinalization;

/**
 * @author vinay
 *
 */
public class GCExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GCExample gcExample = new GCExample();
		gcExample = null;
		gc();
		runFinalization();
		 gcExample = new GCExample();

		 getRuntime().gc();
		 runFinalization();
//		throw new NullPointerException();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage Collector Called");
		System.out.println("Object Garbage Collected is: "+this);
		throw new NullPointerException();
	}

}
