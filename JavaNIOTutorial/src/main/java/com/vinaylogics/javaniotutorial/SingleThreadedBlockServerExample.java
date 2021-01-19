package com.vinaylogics.javaniotutorial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockServerExample {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while (true){
            handle(ss.accept());

        }
    }

    private static void handle(Socket s) throws IOException {
        try(// never null
            s;
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream()) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(transmogrify(data));
            }
        }finally {
            System.out.println("Disconnected from "+s);
        }
    }

    private static int transmogrify(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}
