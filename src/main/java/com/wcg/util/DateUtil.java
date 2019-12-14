package com.wcg.util;


import org.apache.commons.lang.StringUtils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

 public static String dateFormat(Date date,String format){
  if (StringUtils.isBlank(format)){
   format = "yyyy-MM-dd HH:mm:ss";
  }
  SimpleDateFormat sf = new SimpleDateFormat(format);
  String str = sf.format(date);
  return str;
 }

 public static Date getNowDate(Date date) {
  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String dateString = formatter.format(date);
  ParsePosition pos = new ParsePosition(8);
  Date currentTime_2 = formatter.parse(dateString, pos);
  return currentTime_2;
 }

 public static String dateStringFormat(String date, String pattern) {
  if (date == null || pattern == null) {
   return null;
  }
  try {
   Date formDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
   return new SimpleDateFormat(pattern, Locale.CHINA).format(formDate);
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }


}
