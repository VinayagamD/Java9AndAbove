/**
 * This package used for cache
 * copyright : Anju, Monic
 */
package com.anjumonic.cache.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This Calculator Cache Helps to store history of Operations
 *
 * @see PrintWriter
 * @see FileWriter
 * @see BufferedWriter
 *
 * @since 10/10/2020
 */
public final class CalculatorCache {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss.sssZ");

    // Singleton INSTANCE for avoid duplicate object
    public static final CalculatorCache INSTANCE = new CalculatorCache();

    // Private no-args constructor to avoid object creation
    private CalculatorCache(){}

    /**
     * This functions stores history of operation
     * @param filename: File Name of the cache ends with log
     * @param data : JSON String Data
     * @return true when successfully stored
     * @throws IOException: File not found
     */
    public boolean storeCache(String filename, String data) throws IOException {
        File file = new File(CalculatorCache.class.getClassLoader().getResource(filename).getFile()+".log");
        if(!file.exists()){
            file.createNewFile();
        }
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            printWriter.println("");
            printWriter.println("time: "+ LocalDateTime.now().format(FORMATTER));
            printWriter.println("data: "+ data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method helps to retrieve all the string data from history log
     * @param filename: name of the log file in class loader
     * @return String history from log
     * @throws IOException : File Not Found
     */
    public String getFromCache(String filename) throws IOException {
        File file = new File(CalculatorCache.class.getClassLoader().getResource(filename).getFile()+".log");
        if(!file.exists()){
            file.createNewFile();
        }
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }
}
