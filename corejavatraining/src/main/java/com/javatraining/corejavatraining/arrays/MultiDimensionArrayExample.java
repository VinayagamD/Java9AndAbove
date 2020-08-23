package com.javatraining.corejavatraining.arrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MultiDimensionArrayExample {
    private static final Random random = new Random(0);

    public static void main(String[] args) throws IOException {
        File file = new File("image.tsv");
        file.createNewFile();
        FileWriter writer = new FileWriter("image.tsv");
        int [][] image = new int[255][255];
//        Writing a value to image
        for (int row = 0; row < 255; row++) {
            for (int col = 0; col < 255; col++) {
                image[row][col] = Math.abs(random.nextInt(255));
            }
        }

        for (int row = 0; row <255; row++) {
            System.out.println("Row : "+row+" ====================");
            for (int col : image[row]) {
                System.out.print(col+"\t");
            }
            System.out.println();
        }
        for (int row = 0; row <255; row++) {
            System.out.println("Row : "+row+" ====================");
            for (int col : image[row]) {
                writer.append(String.valueOf(col)).append("\t");
            }
            writer.append("\n");
            System.out.println();
        }

    }
}
