package com.javatraining.corejavatraining.streams;

import okhttp3.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InputStreamHttpMethod {

    public static void main(String[] args) throws IOException {
//        getUsingHttpUrlConnectionForHtml();
//        getUsingHttpUrlConnection();
        getDataFromOkHttpBuilder();
    }

    private static void getDataFromOkHttpBuilder() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .method("GET", null)
                .build();
         Call call    =client.newCall(request);
         Response response = call.execute();
        if(response.isSuccessful()){
            File file = new File("data.json");
            if(!file.exists())
                file.createNewFile();
            try(FileOutputStream fos = new FileOutputStream("data.json");) {
                fos.write(response.body().bytes());
            }catch (Exception e){
                e.printStackTrace();
            }


        }
            /*client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if(response.isSuccessful()){
                        File file = new File("data.json");
                        if(!file.exists())
                            file.createNewFile();
                        try(FileOutputStream fos = new FileOutputStream("data.json");) {
                            fos.write(response.body().bytes());
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }

                }
            });
*/
    }

    private static void getUsingHttpUrlConnection() throws MalformedURLException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        processRequest(url);
    }

    private static void getUsingHttpUrlConnectionForHtml() throws MalformedURLException {
        URL url = new URL("https://jsonplaceholder.typicode.com/");
        processRequest(url);
    }

    private static void processRequest(URL url) {
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
