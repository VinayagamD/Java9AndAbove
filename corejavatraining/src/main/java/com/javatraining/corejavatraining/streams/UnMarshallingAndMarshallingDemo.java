package com.javatraining.corejavatraining.streams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.javatraining.corejavatraining.streams.dto.Post;

public class UnMarshallingAndMarshallingDemo {

    public static void main(String[] args) {
        try{
           String data = Files.readString(Paths.get("data.json"));
           JSONArray jsonArray  = new JSONArray(data);
           List<Post> posts = new ArrayList<>();
          /* if(!jsonArray.isEmpty()){
               for (int i = 0; i < jsonArray.length(); i++) {
                    posts.add(Post.fromJSON(jsonArray.getJSONObject(i)));
               }
           }*/
           jsonArray.forEach(json -> posts.add(Post.fromJSON((JSONObject) json)));
           posts.forEach(System.out::println);

           JSONArray jsonArray1 = new JSONArray();
          posts.forEach(post -> {

              jsonArray1.put(posts.indexOf(post),post.toJSON());
          });

           JSONObject jsonObject = new JSONObject();
           jsonObject.put("posts", jsonArray1);
            System.out.println(jsonObject);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
