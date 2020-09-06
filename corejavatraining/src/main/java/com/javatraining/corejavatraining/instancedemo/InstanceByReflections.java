package com.javatraining.corejavatraining.instancedemo;

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
			InstanceByReflections reflections = constructor.newInstance();
			reflections.setName("Train java");
			System.out.println(reflections.name);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} 
	}

}
