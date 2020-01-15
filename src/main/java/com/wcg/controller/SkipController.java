package com.wcg.controller;

import com.wcg.service.CargoService;
import com.wcg.service.OrderService;
import com.wcg.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 页面跳转
 */
@Controller
public class SkipController {
 @Autowired
 private CargoService cargoService;
 @Autowired
 private SupplierService supplierService;
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

 /**
  * 修改密码界面
  */
 @RequestMapping("admin-gallery")
 public String gallery(){
  return "admin-gallery";
 }

 /**
  * 跳转到商品入库页面
  * @return
  */
 @RequestMapping("enterUI")
 public String enterUI(){
  return "admin-enter";
 }

 /**
  * 跳转到仓库页面
  * @return
  */
 @RequestMapping("houseUI")
 public String houseUI(){
  return "admin-house";
 }

 /**
  * 跳转到商品出库页面
  * @return
  */
 @RequestMapping("outUI")
 public String outUI(){
  return "admin-out";
 }

 /**
  * 跳转到订单页面
  * @return
  */
 @RequestMapping("orderUI")
 public String orderUI(){
  return "admin-order";
 }

 /**
  * 删除货物信息
  */
 @RequestMapping(value = "delC",method = RequestMethod.GET)
 public String delCargo(@RequestParam(value = "cargoId") Integer obj){

  cargoService.deleteByPrimaryKey(obj);
  return "admin-cargo";
 }

    /**
     * 删除供应商
     */
    @RequestMapping(value = "delS",method = RequestMethod.GET)
    public String delSupplier(@RequestParam(value = "supplierId") Integer supplierId){
        supplierService.deleteByPrimaryKey(supplierId);
        return "admin-supplier";
    }

}
