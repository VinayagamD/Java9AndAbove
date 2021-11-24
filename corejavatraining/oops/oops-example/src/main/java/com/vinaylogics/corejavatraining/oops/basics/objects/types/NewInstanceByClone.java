/**
 * 
 */
package com.vinaylogics.corejavatraining.oops.basics.objects.types;

/**
 * @author vinay
 *
 */
public class NewInstanceByClone implements Cloneable{

	String name = "Train Java";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NewInstanceByClone nIBC = new NewInstanceByClone();
		try {
			NewInstanceByClone nIBC2 = (NewInstanceByClone) nIBC.clone();
			System.out.println(nIBC2.name);
			System.out.println(nIBC);
			System.out.println(nIBC2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("Clone called");
		return super.clone();
	}
	
	
	
	

}
