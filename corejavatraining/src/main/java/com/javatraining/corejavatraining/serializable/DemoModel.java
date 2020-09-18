/**
 * 
 */
package com.javatraining.corejavatraining.serializable;

import java.io.Serializable;

/**
 * @author vinay
 *
 */
public class DemoModel implements Serializable {

	private static final long serialVersionUID = 5023558613319488551L;
	
	private String name;
	private String surname;
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

}
