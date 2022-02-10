/**
 * 
 */
package com.vinaylogics.corejavatraining.oops.basics.objects.types;

/**
 * @author vinay
 *
 */
public class InstanceByNewInstance {
	
	String name ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Class<?> cls = Class.forName("com.vinaylogics.corejavatraining.oops.basics.objects.types.InstanceByNewInstance");
			InstanceByNewInstance incByNI = (InstanceByNewInstance) cls.newInstance();
			System.out.println(incByNI);
			incByNI.name = "Test By Class.forName";
			System.out.println(incByNI.name);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}