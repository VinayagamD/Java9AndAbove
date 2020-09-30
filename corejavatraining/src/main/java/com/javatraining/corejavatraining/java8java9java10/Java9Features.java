package com.javatraining.corejavatraining.java8java9java10;

import java.io.*;
import java.nio.file.Files;

public class Java9Features {

    public static void main(String[] args) throws IOException {
        Java9Features java9Features = new Java9Features();
        FileInputStream fileInputStream = new FileInputStream(new File(java9Features.getClass().getClassLoader().getResource("message.txt").getFile()));
        try(fileInputStream;
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream))){
            String line;
            while ((line = fileReader.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Files.lines(new File(java9Features.getClass().getClassLoader().getResource("message.txt").getFile()).toPath())
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);
    }
}
