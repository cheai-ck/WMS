package com.wcg.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date date(Date date){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
        String dateString = sdf.format(date);
        ParsePosition pos = new ParsePosition(8);
        Date date1 = sdf.parse(dateString,pos);
        return date1;
    }

    public static String getTodayString() {
        Date today=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = sdf.format(today);//今天的日期
        return todayDate;
    }

    public static String getCurrentDateAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(getCurrentUtilDate());
    }

    public static Date getCurrentUtilDate() {
        return Calendar.getInstance().getTime();
    }

}
