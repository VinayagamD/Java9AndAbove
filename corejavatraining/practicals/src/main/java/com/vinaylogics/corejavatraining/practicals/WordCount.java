package com.vinaylogics.corejavatraining.practicals;

import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) throws IOException {
        Map<String,Integer> wordMap = new HashMap<>();
        File file = new File("outputFile.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        try(
                Scanner br = new Scanner(Objects.requireNonNull(
                        WordCount.class.getClassLoader()
                                .getResourceAsStream("inputFile.txt")));
                PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            while (br.hasNextLine()){
                for(String word : br.nextLine().split(" ")){
                    if(wordMap.containsKey(word)){
                        wordMap.put(word, wordMap.get(word)+1);
                    } else {
                        wordMap.put(word,1);
                    }
                }
            }
            Map<String, Integer> sortedWordMap = new TreeMap<>(wordMap);
            sortedWordMap.forEach((key, value) ->{
                    printWriter.print(key);
                    printWriter.print(":");
                    printWriter.print(value);
                    printWriter.println();


            printWriter.flush();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
