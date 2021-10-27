package com.vinaylogics.corejavatraining.javaadditionalmodule.java9;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

public class Java9Demo {

    public static void main(String[] args) throws IOException {
        Java9Demo Java9Demo = new Java9Demo();
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(Java9Demo.getClass().getClassLoader().getResource("message.txt")).getFile());
        try(fileInputStream;
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream))){
            String line;
            while ((line = fileReader.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Files.lines(new File(Objects.requireNonNull(Java9Demo.getClass().getClassLoader().getResource("message.txt")).getFile()).toPath())
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);
    }
}
