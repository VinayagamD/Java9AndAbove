package com.javatraining.corejavatraining.collections.coreInterface;

import java.io.Serializable;

public class DemoData implements Serializable{

	private static final long serialVersionUID = 6555261605080120203L;
	
	private String name;

	public DemoData(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}