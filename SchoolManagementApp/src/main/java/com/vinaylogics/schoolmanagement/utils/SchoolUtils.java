package com.vinaylogics.schoolmanagement.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vinaylogics.schoolmanagement.utils.dataconverter.LocalDateTimeAdapter;

import java.time.LocalDateTime;

public final class SchoolUtils {
    private static Gson gson;

    private SchoolUtils() {
    }

    public static Gson  getGson(){
        if(gson == null){
            gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();
        }
       return gson;
    }
}
