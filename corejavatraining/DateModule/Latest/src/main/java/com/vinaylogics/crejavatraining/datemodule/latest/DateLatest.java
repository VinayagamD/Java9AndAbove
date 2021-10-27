package com.vinaylogics.crejavatraining.datemodule.latest;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateLatest {

    public static void main(String[] args) {
        // Java 8
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SS");
        System.out.println(localDateTime.format(dateTimeFormatter));
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(ZoneId.systemDefault().getId());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(zonedDateTime.format(dateTimeFormatter));
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(offsetDateTime.format(dateTimeFormatter));
    }
}
