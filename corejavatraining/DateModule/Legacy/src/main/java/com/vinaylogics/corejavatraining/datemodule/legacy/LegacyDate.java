package com.vinaylogics.corejavatraining.datemodule.legacy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LegacyDate {

    public static void main(String[] args) {
        // Legacy
        Date date  = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);
        /*date = new Date(2020, 03, 01);
        System.out.println(date);*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy,HH:mm:ss.SSZ");
        System.out.println(simpleDateFormat.format(date));
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
        System.out.println(date.getTime());
    }
}
