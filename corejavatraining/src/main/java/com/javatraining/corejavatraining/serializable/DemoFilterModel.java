package com.javatraining.corejavatraining.serializable;

import java.io.Serial;
import java.io.Serializable;

public class DemoFilterModel implements Serializable{
	@Serial
	private static final long serialVersionUID = 2230175226344447634L;
	private static String message;
	private String name;
	private transient String surname;
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
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the message
	 */
	public static String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public static void setMessage(String message) {
		DemoFilterModel.message = message;
	}
	
	

}
