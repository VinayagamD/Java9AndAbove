package com.vinay.designpatterns.creational;

public class SingletonClassLazyThreadSafe2 {
	private static Object lock = new Object();

	private static SingletonClassLazyThreadSafe2 instance;
	
	private SingletonClassLazyThreadSafe2() {
		
	}

	public static SingletonClassLazyThreadSafe2 getInstance() {
		if(instance == null) {
			synchronized (lock) {
				if(instance == null) {
					instance = new SingletonClassLazyThreadSafe2();
				}
			}
			
		}
		return instance;
	}
	
	
}
