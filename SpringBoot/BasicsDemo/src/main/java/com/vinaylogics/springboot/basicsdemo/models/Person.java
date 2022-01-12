package com.vinaylogics.springboot.basicsdemo.models;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Person implements Serializable {

    private String name;
    private String passion;

}
