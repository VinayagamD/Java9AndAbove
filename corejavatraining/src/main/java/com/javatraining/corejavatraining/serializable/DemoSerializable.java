/**
 * 
 */
package com.javatraining.corejavatraining.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author vinay
 *
 */
public class DemoSerializable {

	public static void main(String[] args) {
		String filename = "file.ser";
		DemoFilterModel demoModel = new DemoFilterModel();
		demoModel.setName("Barathwaj");
		demoModel.setSurname("M");
		demoModel.setMessage("Hello Message TO barathwaj");


        //Saving of object in a file 
      
		try (FileOutputStream file = new FileOutputStream(filename);
			 ObjectOutputStream out = new ObjectOutputStream(file); ){
			
			out.writeObject(demoModel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DemoFilterModel dDemoModel = null;
		try(FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			
			dDemoModel = (DemoFilterModel) in.readObject();
			System.out.println(dDemoModel.getName());
			System.out.println(dDemoModel.getSurname());
			System.out.println(dDemoModel.getMessage());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
