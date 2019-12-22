package com.wcg.controller;

import com.wcg.error.BusinessException;
import com.wcg.error.EmBusinessError;
import com.wcg.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

 @ExceptionHandler(Exception.class)
 @ResponseStatus(HttpStatus.OK)
 @ResponseBody
 //定义exceptionhandler解决未被controller层吸收的exception
 public Object handlerException(HttpServletRequest request, Exception ex) throws Exception {
  Map<String, Object> map = new HashMap<>();
  if (ex instanceof BusinessException) {
   BusinessException businessException = (BusinessException) ex;
   map.put("errCode", businessException.getErrCode());
   map.put("errMsg", businessException.getErrMsg());
  }
//  else{
//   throw new Exception();
//  map.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
//  map.put("errMsg",EmBusinessError.UNKNOWN_ERROR.getErrMsg());
//  }
  return CommonReturnType.create(map, "fail");
 }
}
