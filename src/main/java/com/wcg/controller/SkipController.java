package com.wcg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class SkipController {
 /**
  * 跳转到index
  * @return
  */
 @RequestMapping("index")
 public String indd(){
  return "admin-index";
 }

 @RequestMapping("/")
 public String login(){
  return "login";
 }

 @RequestMapping("/test")
 public String mainPage(){
  return "index";
 }

 @RequestMapping("admin-help")
 public String help(){
  return "admin-help";
 }

 @RequestMapping("admin-cargo")
 public String cargo(){
  return "admin-cargo";
 }

 @RequestMapping("admin-supplier")
 public String supplier(){return "admin-supplier";}

}
