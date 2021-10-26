package com.vinaylogics.corejavatraining.utilsdemo.properies_demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        final Properties properties = new Properties();
        try {

//            properties.setProperty("name", "test");
//            System.out.println(properties.getProperty("name"));
            PropertiesDemo propertiesDemo = new PropertiesDemo();
            InputStream inputStream = propertiesDemo.getClass().getClassLoader().getResourceAsStream("test.properties");
            properties.load(inputStream);
            properties.forEach((k,v) -> {
                System.out.println("Key = "+k);
                System.out.println("Value = "+v);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
