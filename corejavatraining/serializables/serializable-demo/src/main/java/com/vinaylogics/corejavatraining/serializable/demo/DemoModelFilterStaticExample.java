package com.vinaylogics.corejavatraining.serializable.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DemoModelFilterStaticExample {
	
	public static void main(String[] args) {
		DemoFilterModel dDemoModel = null;
		 String filename = "file.ser"; 
		 
		try(FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			
			dDemoModel = (DemoFilterModel) in.readObject();
			System.out.println(dDemoModel.getName());
			System.out.println(dDemoModel.getSurname());
			System.out.println(dDemoModel.getMessage());
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
