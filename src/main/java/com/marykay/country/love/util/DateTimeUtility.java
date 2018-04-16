package com.marykay.country.love.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtility {
    public static long GetTimeMilliseconds(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.getTimeInMillis();
    }

    public static String GetTime(long millisecond){
        Date date = new Date(millisecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
