package com.wcg.controller;

import com.wcg.dataobject.*;
import com.wcg.error.BusinessException;
import com.wcg.error.EmBusinessError;
import com.wcg.response.CommonReturnType;
import com.wcg.service.*;
import com.wcg.util.KeyUtil;
import com.wcg.util.Md5;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class mainController {
 @Autowired
 private CargoService cargoService;
 @Autowired
 private SupplierService supplierService;
@Autowired
private OrderService orderService;
@Autowired
private WareHouseService wareHouseService;
@Autowired



 /**
  * 查询所有商品
  * @return
  */
 @RequestMapping("cargo")
 public ModelAndView ind(){
  ModelAndView mv = new ModelAndView("cargo");
  List<CargoDO> list = cargoService.selectAll();
  mv.addObject("cargolist",list);
  //request.getSession().setAttribute("cargoList",list);
  return mv;
 }

 /**
  * 跳转到商品入库页面
  * @return
  */
 @RequestMapping("enterUI")
 public String enterUI(){
  return "enter";
 }

 /**
  * 商品入库
  * @param houseDO
  * @return
  */
 @ResponseBody
 @RequestMapping("enter")
 public String enter(@RequestBody WareHouseDO houseDO){
  houseDO.setState("在库中");
  System.out.println(houseDO.getcName()+""+houseDO.getsName());
  List<WareHouseDO> list =wareHouseService.selectcs(houseDO.getcName(),houseDO.getsName());
  if (list.size()!=0) {
   for (WareHouseDO houseDO1 : list) {
    houseDO.setAmount(houseDO1.getAmount() + houseDO.getAmount());
    houseDO.setHouseId(houseDO1.getHouseId());
    //更新库存
    int i = wareHouseService.updateByPrimaryKeySelective(houseDO);
   }
  }else {
   wareHouseService.insertSelective(houseDO);
  }
 return "success";
 }

 /**
 * 查询所有供应商
 */
@RequestMapping("selectSupplier")
public ModelAndView selectSupplier(){
 ModelAndView mv = new ModelAndView("enter");
List<SupplierDO> list = supplierService.selectAll();
List<CargoDO> list1 = cargoService.selectAll();
mv.addObject("supplierList",list);
mv.addObject("cargoList",list1);
 return mv;
}

 /**
  * 查询仓库
  * @return
  */

 public ModelAndView sr(){
  ModelAndView mv = new ModelAndView("enter");
  List<WareHouseDO> list = wareHouseService.selectAll();
  mv.addObject("wareList",list);
  return mv;
 }

/**
 * 显示仓库页面
 */
@RequestMapping("house")
public ModelAndView houseUI(){
 ModelAndView mv = new ModelAndView("house");
 List<WareHouseDO> list = wareHouseService.selectAll();

/* for (HouseDO houseDO:list){
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  System.out.println(sdf.format(houseDO.getUpDate()));
  String sj = sdf.format(houseDO.getUpDate());
  mv.addObject("sj",sj);
 }*/

mv.addObject("houseList",list);
 return mv;
}

/**
 * 跳转出库页面
 */
@RequestMapping("out")
 public ModelAndView out(@RequestParam(value = "houseid")Integer cId, HttpServletRequest request){
 //按货物id查询仓库
 WareHouseDO wareHouseDO = wareHouseService.selectByPrimaryKey(cId);
 /*HouseDO houseDO = hourseService.selectByPrimaryKey(cId);
 CargoDO cargoDO =cargoService.selectByPrimaryKey(houseDO.getCId());
 System.out.println(cargoDO.toString());
 SupplierDO supplierDO = supplierService.selectByPrimaryKey(houseDO.getSId());
 request.getSession().setAttribute("houseid",cId);
 request.getSession().setAttribute("carName",cargoDO.getCargoName());
 request.getSession().setAttribute("supName",supplierDO.getSupplierName());*/
 ModelAndView mv  =new ModelAndView("out");
 mv.addObject("wareHouse",wareHouseDO);
 return mv;
}

/**
 * 出货生成订单
 */
/*@ResponseBody
@RequestMapping("outOrder")
public String outOrder(@RequestBody OrderDO orderDO,HttpServletRequest request){

 //生成订单号
 String s = KeyUtil.genUniqueKey();
 orderDO.setOrderId(s);
 orderService.insertSelective(orderDO);
 request.getSession().setAttribute("order",orderDO);
Integer cId =(Integer)request.getSession().getAttribute("houseid");
  HouseDO wareHouseDO = new HouseDO();
 wareHouseDO.setState("已出库");
 wareHouseDO.setHouseId(cId);
 System.out.println(wareHouseDO.getState());
 //int i =HouseDO.updateByPrimaryKeySelective(wareHouseDO);
 return "success";
}*/

 /**
  * 出货生成订单ex
  * @param
  * @param
  * @return
  */
 @ResponseBody
@RequestMapping("outOrder")
public String outOrder(@RequestBody OrderDO order){
  //生成订单号
  List<WareHouseDO> list = wareHouseService.selectcs(order.getCargoName(),order.getSupplier());
  for (WareHouseDO wareHouseDO:list){
   wareHouseDO.setAmount(wareHouseDO.getAmount()-order.getAmount());
   if (wareHouseDO.getAmount()<0){
    wareHouseDO.setState("缺货");
    wareHouseService.updateByPrimaryKeySelective(wareHouseDO);
    return "fail";
   }
  }
  String s = KeyUtil.genUniqueKey();
  order.setOrderId(s);
  System.out.println(order.toString());
  orderService.insertSelective(order);
 return "success";
}

 /**
  * 出货生成订单max
  * @param
  * @param
  * @return
  */
 /*@ResponseBody
 @RequestMapping("outOrder")
 public String outOrder(@RequestBody Order order){
  //生成订单号
  System.out.println(order.toString());

  *//*WareHouseDO wareHouseDO1 =wareHouseService.selectByPrimaryKey(wareHouseDO.getHouseId());
  wareHouseDO1.setAmount(wareHouseDO1.getAmount()-wareHouseDO.getAmount());
  if (wareHouseDO1.getAmount()<0){
   wareHouseDO1.setState("缺货");
   wareHouseService.updateByPrimaryKeySelective(wareHouseDO1);
   return "fail";
  }
  String s = KeyUtil.genUniqueKey();
  System.out.println(s);
  Order order = new Order();
  //设置订单号
  order.setOrderId(s);
  order.setCargoName(wareHouseDO.getcName());
  order.setAmount(wareHouseDO.getAmount());
  order.setCustomerName(wareHouseDO.getcName());
  wareHouseService.updateByPrimaryKeySelective(wareHouseDO1);
*//*

  return "success";
 }*/

/**
 * 跳转到订单
 */
@RequestMapping("order")
 public ModelAndView order(){
 ModelAndView mv = new ModelAndView("order");
 List<OrderDO> orderDO  = orderService.selectAll();
 mv.addObject("orderList",orderDO);
 return mv;
}



/**
 * 修改密码界面
 */
@RequestMapping("admin-gallery")
public String gallery(){
 return "admin-gallery";
}



}
