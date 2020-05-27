package com.vinay.designpatterns.creational;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonClassLazyThreadSafe3 {
	private static Lock lock = new ReentrantLock(); 

	private static SingletonClassLazyThreadSafe3 instance;
	
	private SingletonClassLazyThreadSafe3() {
		
	}

	public static SingletonClassLazyThreadSafe3 getInstance() {
		if(instance == null) {
			lock.lock();
			try {
				instance = new SingletonClassLazyThreadSafe3();
			} finally {
				lock.unlock();
			}
		}
		return instance;
	}
	
	
}
