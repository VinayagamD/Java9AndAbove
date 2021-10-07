package com.vinaylogics.corejavatraining.io.basics;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;

public class FileDownload {
    public static void main(String[] args) throws MalformedURLException {
        HttpClient httpClient = HttpClient.newBuilder().build();

       /* URL uri = new URL("https://www.bensound.com/bensound-music/bensound-ukulele.mp3");
        try(BufferedInputStream in = new BufferedInputStream(uri.openStream());
            FileOutputStream fileOutputStream= new FileOutputStream(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("songs.mp3")).getFile())){
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            DataLine.Info daInfo = new DataLine.Info(Clip.class, null);
            try {
                URL sounURL = new URL("https://www.bensound.com/bensound-music/bensound-ukulele.mp3");

                AudioInputStream inputStream = AudioSystem.getAudioInputStream(sounURL);
                DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(inputStream);
                clip.start();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("music");
        }
    }
}
