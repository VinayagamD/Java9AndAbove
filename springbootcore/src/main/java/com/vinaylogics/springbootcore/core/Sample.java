package com.vinaylogics.springbootcore.core;

import com.vinaylogics.springbootcore.models.MyModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Sample {

    private final String name;
    private final MyModel myModel;

    public Sample(@Qualifier("name") String name, MyModel myModel) {
        this.name = name;
        this.myModel = myModel;
    }

    public void printMessage(){
        System.out.println("Print Message");
        System.out.println(name);
        System.out.println(myModel);
    }

}
