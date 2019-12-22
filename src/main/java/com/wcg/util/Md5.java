package com.wcg.util;



import com.alibaba.druid.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5 {

 public static String md5(String password){
  try {
   MessageDigest md = MessageDigest.getInstance("md5");
   //通过MD5计算摘要
   try {
    byte[] bytes = md.digest(password.getBytes("UTF-8"));
    String s = Base64.byteArrayToBase64(bytes);
    return s;

   } catch (UnsupportedEncodingException e) {
    e.printStackTrace();
   }
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  return null;
 }

}
