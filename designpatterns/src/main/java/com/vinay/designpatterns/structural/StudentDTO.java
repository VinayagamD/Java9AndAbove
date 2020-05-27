package com.vinay.designpatterns.structural;

import java.io.Serializable;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 4014589785714136014L;
	
	private String name;
	private String deparment;
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
	 * @return the deparment
	 */
	public String getDeparment() {
		return deparment;
	}
	/**
	 * @param deparment the deparment to set
	 */
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deparment == null) ? 0 : deparment.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDTO other = (StudentDTO) obj;
		if (deparment == null) {
			if (other.deparment != null)
				return false;
		} else if (!deparment.equals(other.deparment))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", deparment=" + deparment + "]";
	}
	
	
	
	

}
