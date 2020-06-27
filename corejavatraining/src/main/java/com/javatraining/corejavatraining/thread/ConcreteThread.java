/**
 * 
 */
package com.javatraining.corejavatraining.thread;

/**
 * @author vinay
 *
 */
public class ConcreteThread extends Thread  {
	
	

	public ConcreteThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Concrete Thread is Running");
		printScore();
	}

	/*@Override
	public synchronized void start() {
		System.out.println("Start");
		super.start();
	}*/
	
	
	private void printScore() {
		for (int i = 0; i <10; i++) {
			System.out.println(super.getName() + " => "+ i);
		}
	}
	

	
	
	
}
