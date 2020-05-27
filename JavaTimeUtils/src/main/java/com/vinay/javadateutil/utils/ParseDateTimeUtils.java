package com.vinay.javadateutil.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ParseDateTimeUtils {
    public static final  DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static LocalDateTime addMinutesToLocalDateTime(String dateTime, Long minutes){
        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER).plusMinutes(minutes);
    }

    public static Date addMinutesToDate(String dateTime, Long minutes){
        return Date.from(LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER).plusMinutes(minutes).toInstant(ZoneOffset.UTC));
    }
}
