/**
 * 
 */
package com.vinaylogics.corejavatraining.oops.basics.objects.types;

import java.io.*;

/**
 * @author vinay
 *
 */
public class DeserializableExample implements Serializable {
    private String name; 
    DeserializableExample(String name) 
    { 
        this.name = name; 
    } 


	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try {
	        DeserializableExample d = new DeserializableExample("GeeksForGeeks");
            System.out.println(d);
            FileOutputStream f = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(d);
            oos.close();
            f.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        try
        {
        	DeserializableExample d;
            FileInputStream f = new FileInputStream("file.txt");
            ObjectInputStream oos = new ObjectInputStream(f);
            d = (DeserializableExample)oos.readObject();
            System.out.println(d.name);
            System.out.println(d);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

	}

}
