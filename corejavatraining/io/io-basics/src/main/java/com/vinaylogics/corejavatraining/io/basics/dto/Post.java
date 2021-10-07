package com.vinaylogics.corejavatraining.io.basics.dto;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.Objects;

public class Post implements Serializable {

    private static final long serialVersionUID = 6084643174018246318L;

    private Long id;
    private Long userId;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long id, Long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public static Post fromJSON(JSONObject jsonObject){
        return new Post(jsonObject.getLong("id"),jsonObject.getLong("userId"),jsonObject.getString("title"),jsonObject.getString("body"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("id", this.id);
        jsonObject.append("userId", this.userId);
        jsonObject.append("title", this.title);
        jsonObject.append("body", this.body);
        return jsonObject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(userId, post.userId) &&
                Objects.equals(title, post.title) &&
                Objects.equals(body, post.body);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, body);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
