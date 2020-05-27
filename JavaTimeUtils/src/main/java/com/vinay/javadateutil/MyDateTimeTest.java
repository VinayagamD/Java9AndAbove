package com.vinay.javadateutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTimeTest {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime localDateTime = LocalDateTime.parse("2020-05-02T16:45:00.000Z", dateTimeFormatter);
        System.out.println(localDateTime);
        System.out.println(localDateTime.plusMinutes(15L));
    }
}
