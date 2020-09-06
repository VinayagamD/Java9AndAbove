package com.javatraining.corejavatraining.streams;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class InputStreamHttpMethod {

    public static void main(String[] args) throws MalformedURLException {
//        getUsingHttpUrlConnection();
        getDataFromOkHttpBuilder();
    }

    private static void getDataFromOkHttpBuilder() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .method("GET", null)
                .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if(response.isSuccessful()){
                        FileOutputStream fos = new FileOutputStream("data.json");
                        fos.write(response.body().bytes());
                        fos.close();
                    }

                }
            });

    }

    private static void getUsingHttpUrlConnection() throws MalformedURLException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection connection = null;
        try{
             connection = (HttpURLConnection) url.openConnection();
             connection.setRequestMethod("GET");
             BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             String line;
             while ((line = br.readLine())!= null){
                 System.out.println(line);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
