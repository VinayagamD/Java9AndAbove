/**
 * 
 */
package com.javatraining.corejavatraining.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vinay
 *
 */
public class ExtendThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> threadNames = Arrays.asList("A","B", "C", "D", "E");
		List<Thread> threads = new ArrayList<>();
		threadNames.forEach(name -> {
			threads.add(new ConcreteThread(name));
		});
		
		threads.forEach(thread -> {
			System.out.println(thread.getName());
		});
		
		threads.forEach(Thread::start);
	}

}
