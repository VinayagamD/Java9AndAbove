package com.javatraining.corejavatraining.training.callback;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostList {

    public static void main(String[] args) throws IOException {
        loadData(posts -> posts.forEach(System.out::println));
    }

    public interface PostDataCallBack{
        void loadData(List<Post> data);
    }

    public static void loadData(PostDataCallBack callBack) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .method("GET", null)
                .build();
        Call call  =client.newCall(request);
        Response response = call.execute();
        if(response.isSuccessful()){
            List<Post> posts = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(Objects.requireNonNull(response.body()).string());
            jsonArray.forEach(json -> posts.add(Post.fromJSON((JSONObject) json)));
            callBack.loadData(posts);
        }
    }


}
