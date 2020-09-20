package com.javatraining.corejavatraining.streams;

import java.io.*;

public class StreamTokenizerDemo {

    public static void main(String[] args) {
        try(Reader reader = new FileReader("data.json");
            ){
            StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
            while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){

                if(streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(streamTokenizer.sval);
                } else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(streamTokenizer.nval);
                } else if(streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("EOL");
                }

            }
            System.out.println("EOF");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
