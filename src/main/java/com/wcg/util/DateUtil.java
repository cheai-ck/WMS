package com.wcg.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date date(Date date){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
        String dateString = sdf.format(date);
        ParsePosition pos = new ParsePosition(8);
        Date date1 = sdf.parse(dateString,pos);
        return date1;
    }
}
