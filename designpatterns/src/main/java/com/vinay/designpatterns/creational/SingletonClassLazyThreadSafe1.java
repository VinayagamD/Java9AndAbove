package com.vinay.designpatterns.creational;

public class SingletonClassLazyThreadSafe1 {

	private static SingletonClassLazyThreadSafe1 instance;
	
	private SingletonClassLazyThreadSafe1() {
		
	}

	public synchronized static SingletonClassLazyThreadSafe1 getInstance() {
		if(instance == null) {
			instance = new SingletonClassLazyThreadSafe1();
		}
		return instance;
	}
	
	
}
