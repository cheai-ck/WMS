package com.wcg.controller;

import com.wcg.dataobject.AdminDO;
import com.wcg.error.BusinessException;
import com.wcg.error.EmBusinessError;
import com.wcg.response.CommonReturnType;
import com.wcg.service.AdminService;
import com.wcg.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController extends BaseController{
 @Autowired
 private AdminService adminService;
 /**
  * 登录验证
  * @param managementUser
  * @param managementPass
  * @param code
  * @param request
  * @return
  * @throws BusinessException
  */
 @RequestMapping(value = "/check",method = {RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})
 @ResponseBody
 public CommonReturnType check(@RequestParam(value = "managementUser") String managementUser,
                               @RequestParam(value = "managementPass") String managementPass,
                               @RequestParam(value = "code")String code, HttpServletRequest request) throws BusinessException {
  String c =(String)request.getSession().getAttribute("verifyCode");
  if (!c.toLowerCase().equals(code.toLowerCase())){
   throw new BusinessException(EmBusinessError.CODE_ERROR);
  }
  //密码md5加密为密文
  String md5Pass = Md5.md5(managementPass);
  AdminDO adminDO=adminService.selectLogin(managementUser,md5Pass);
  if (adminDO==null){
   throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
  }
  request.getSession().setAttribute("admin",adminDO.getManagementUser());
  return CommonReturnType.create(adminDO);
 }


 /**
  * 修改密码
  * @param request
  * @param managementPass 原密码
  * @param password 新密码
  * @return
  * @throws BusinessException
  */
 @RequestMapping(value = "/changepwd",method = {RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})
 @ResponseBody
 public CommonReturnType changePass(HttpServletRequest request, @RequestParam(value = "managementPass")String managementPass, @RequestParam(value = "password")String password) throws BusinessException {
  String managementUser = (String)request.getSession().getAttribute("admin");
  String md5Pass = Md5.md5(managementPass);
  AdminDO adminDO=adminService.selectLogin(managementUser,md5Pass);
  if (adminDO==null){
   throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
  }
  String md5Password =Md5.md5(password);
  int i = adminService.updatePass(managementUser,md5Password);
  if (i==0){
   throw new BusinessException(EmBusinessError.UNKNOWN_ERROR);
  }
  return CommonReturnType.create(adminDO);
 }

}
