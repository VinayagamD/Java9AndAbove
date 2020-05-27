package com.vinay.designpatterns.creational;

public class SingletonClassLazy {

	private static SingletonClassLazy instance;
	
	private SingletonClassLazy() {
		
	}

	public static SingletonClassLazy getInstance() {
		if(instance == null) {
			instance = new SingletonClassLazy();
		}
		return instance;
	}
	
	
}
