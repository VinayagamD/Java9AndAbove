package com.vinaylogics.corejavatraining.collectionframework.generics;

public class GenericMethodExample {

	public <T> T isNull(T t) {
		if( t == null) {
			throw new NullPointerException("Object Cannot be null");
		}
		System.out.println(t.getClass().getSimpleName());
		return t;
	}
	
	public static void main(String[] args) {
		GenericMethodExample genericMethodExample = new GenericMethodExample();
		System.out.println(genericMethodExample.isNull("Test"));
		System.out.println(genericMethodExample.isNull(10));
//		genericMethodExample.isNull(null);
	}
}
