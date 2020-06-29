package com.vinaylogics.springbasics.springunderstand.model;

import java.io.Serializable;

public class StudentDILooseCouple implements Serializable {

    Post post;

    public StudentDILooseCouple(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
