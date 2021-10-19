package com.vinaylogics.corejavatraining.collectionframework.generics;

public class GenericClass<T> {
	
	private T t;

	public GenericClass() {
	}

	public GenericClass(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}