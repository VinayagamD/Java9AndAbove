/**
 * 
 */
package com.javatraining.corejavatraining.oops.instancedemo;

/**
 * @author vinay
 *
 */
public class InstnaceByNewInstance {
	
	String name ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Class cls = Class.forName("com.javatraining.corejavatraining.oops.instancedemo.InstnaceByNewInstance");
			InstnaceByNewInstance incByNI = (InstnaceByNewInstance) cls.newInstance();
			incByNI.name = "Test By Class.forName";
			System.out.println(incByNI.name);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
