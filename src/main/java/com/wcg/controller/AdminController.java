package com.wcg.controller;

import com.wcg.dataobject.AdminDO;
import com.wcg.error.BusinessException;
import com.wcg.error.EmBusinessError;
import com.wcg.response.CommonReturnType;
import com.wcg.service.AdminService;
import com.wcg.util.Md5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController extends BaseController{
 @Autowired
 private AdminService adminService;


 /**
  * 登录验证
  * @param managementUser
  * @param managementPass
  * @param code 验证码
  * @param request
  * @return
  * @throws BusinessException
  */
 @ResponseBody
 @RequestMapping(value = "/check",method = {RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})
 public String check(@RequestParam(value = "managementUser") String managementUser,
                     @RequestParam(value = "managementPass") String managementPass,
                     @RequestParam(value = "code") String code, HttpServletRequest request) throws BusinessException {
     String c = (String) request.getSession().getAttribute("verifyCode");
     if (!c.toLowerCase().equals(code.toLowerCase())) {
         throw new BusinessException(EmBusinessError.CODE_ERROR);
     }
     //密码md5加密为密文
     String md5Pass = Md5.md5(managementPass);
     Subject subject = SecurityUtils.getSubject();
     UsernamePasswordToken token = new UsernamePasswordToken(managementUser, md5Pass);
     subject.login(token);
     //subject.getSession().setAttribute("admin",adminDO.getManagementUser());
     request.getSession().setAttribute("admin", (String) token.getPrincipal());
     return "success";
 }




 /**
  * 修改密码
  * @param request
  * @param managementPass 原密码
  * @param password 新密码
  * @return
  * @throws BusinessException
  */
 @ResponseBody
 @RequestMapping(value = "/changepwd",method = {RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})
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

    /**
     * 登出
     * @return
     */
 @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
     Subject subject = SecurityUtils.getSubject();
     subject.logout();
    /* //清除所有session
     HttpSession session = request.getSession();
     //清除session的值
     session.invalidate();*/
     return "redirect:/";
    }
}

