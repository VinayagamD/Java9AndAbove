package com.javatraining.corejavatraining.oops.instancedemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanceByReflections {
	private String name; 
	InstanceByReflections() 
    { 
    } 
    public void setName(String name) 
    { 
        this.name = name; 
    } 

	public static void main(String[] args) {
		try {
			Constructor<InstanceByReflections> constructor = InstanceByReflections.class.getDeclaredConstructor();
			InstanceByReflections rflections = constructor.newInstance();
			rflections.setName("Train java");
			System.out.println(rflections.name);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} 
	}

}
