package com.javatraining.corejavatraining.instancedemo;

public class InstanceByNew {
	
	String name;

	public static void main(String[] args) {
		InstanceByNew insBN = new InstanceByNew();
		System.out.println(insBN.name);
		insBN.name = "New Keyword";
		System.out.println(insBN);
		System.out.println(insBN.name);
	}

}
