package com.javatraining.corejavatraining.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateExample {

    public static void main(String[] args) {

        // Legacy
        Date date  = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);
        /*date = new Date(2020, 03, 01);
        System.out.println(date);*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy,HH:mm:ss.SSZ");
        System.out.println(simpleDateFormat.format(date));
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
        System.out.println(date.getTime());

        // Java 8
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDateTime.format(dateTimeFormatter));
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(ZoneId.systemDefault().getId());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(zonedDateTime.format(dateTimeFormatter));
    }
}
