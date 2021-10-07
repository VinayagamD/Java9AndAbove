package com.vinaylogics.corejavatraining.io.basics;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class InputStreamHttpMethod {

    public static void main(String[] args) throws IOException {
//        getUsingHttpUrlConnectionForHtml();
//        getUsingHttpClientConnectionForHtml();
//        getUsingHttpUrlConnection();
//        getUsingHttpClientConnection();
        getDataFromOkHttpBuilder();
    }

    private static void getDataFromOkHttpBuilder() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .method("GET", null)
                .build();
         Call call = client.newCall(request);
         Response response = call.execute();
        if(response.isSuccessful()){
            File file = new File("data.json");
            if(!file.exists()) {
                file.createNewFile();
            }
            try(FileOutputStream fos = new FileOutputStream(file);) {
                fos.write(Objects.requireNonNull(response.body()).bytes());
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

    private static void getUsingHttpClientConnection() throws MalformedURLException {
        processRequest(URI.create("https://jsonplaceholder.typicode.com/posts"),"application/json");
    }

    private static void getUsingHttpUrlConnectionForHtml() throws MalformedURLException {
        URL url = new URL("https://jsonplaceholder.typicode.com/");
        processRequest(url);
    }

    private static void getUsingHttpClientConnectionForHtml() throws MalformedURLException {
        processRequest(URI.create("https://jsonplaceholder.typicode.com/"),"text/html; charset=UTF-8");
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

    private static void processRequest(URI uri, String contentType){
        try {
        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", contentType)
                .GET().build();

        HttpResponse<String> response   = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
