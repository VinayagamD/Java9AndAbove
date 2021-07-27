package com.javatraining.corejavatraining.streams;

import java.io.*;

public class StreamTokenizerDemo {

    public static void main(String[] args) {
        try(Reader reader = new FileReader(ClassLoader.getSystemResource("lorem_ipsum.txt").getFile())){
            StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
            while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){
                switch (streamTokenizer.ttype){
                    case StreamTokenizer.TT_WORD ->  {
                        System.out.println("WORD");
                        System.out.println(streamTokenizer.sval);
                    }
                    case StreamTokenizer.TT_NUMBER -> {
                        System.out.println("Number");
                        System.out.println(streamTokenizer.nval);
                    }
                    case StreamTokenizer.TT_EOL -> System.out.println("End of Line");
                    default -> System.out.println("EOF");
                }
            }
            System.out.println("EOF");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
