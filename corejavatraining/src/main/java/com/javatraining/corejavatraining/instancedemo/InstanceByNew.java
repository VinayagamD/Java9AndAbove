package com.javatraining.corejavatraining.instancedemo;

public class InstanceByNew {
	
	String name;
	
	public static void main(String[] args) {
		InstanceByNew incBN = new InstanceByNew();
		incBN.name = "New Keyword";
		System.out.println(incBN.name);
	}

}
