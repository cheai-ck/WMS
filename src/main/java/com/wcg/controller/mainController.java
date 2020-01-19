package com.wcg.controller;

import com.wcg.dataobject.*;
import com.wcg.error.BusinessException;
import com.wcg.error.EmBusinessError;
import com.wcg.response.CommonReturnType;
import com.wcg.service.*;
import com.wcg.util.DateUtil;
import com.wcg.util.KeyUtil;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class mainController extends BaseController {
 @Autowired
 private CargoService cargoService;
 @Autowired
 private SupplierService supplierService;
@Autowired
private OrderService orderService;
@Autowired
private WareHouseService wareHouseService;
@Autowired
private CustomerService customerService;
 /**
  * 查询所有商品
  * @return
  */
  @RequestMapping("cargo")
 public CommonReturnType ind() throws BusinessException {
  ModelAndView mv = new ModelAndView("cargo");
  List<CargoDO> list = cargoService.selectAll();
  if (list==null){
   throw new BusinessException(EmBusinessError.CARGO_NOT_EXIST);
  }
  return CommonReturnType.create(list);
 }


 /**
  * 按名字查询
  * @return
  */
 @RequestMapping("cargoid")
 public CommonReturnType indd(@RequestBody JSONObject obj) throws BusinessException {
  String cargoName =obj.getString("cargoName");
  List<CargoDO> list = cargoService.selectName(cargoName);
  if (list.size()==0){
   throw new BusinessException(EmBusinessError.CARGO_NOT_EXIST);
  }
  return CommonReturnType.create(list);
 }


 /**
  * 按名字查询
  * @return
  */
 @RequestMapping("selectsupplierName")
 public CommonReturnType supplierName(@RequestBody JSONObject obj) throws BusinessException {
  String supplierName =obj.getString("supplierName");
  List<SupplierDO> list = supplierService.selectName(supplierName);
  if (list.size()==0){
   throw new BusinessException(EmBusinessError.SUPPLIER_NOT_EXIST);
  }
  return CommonReturnType.create(list);
 }

    /**
     * 按名字查询
     * @return
     */
    @RequestMapping("selectorderName")
    public CommonReturnType orderName(@RequestBody JSONObject obj) throws BusinessException {
        String cargoName =obj.getString("cargoName");
        List<SupplierDO> list = orderService.selectName(cargoName);
        if (list.size()==0){
            throw new BusinessException(EmBusinessError.SUPPLIER_NOT_EXIST);
        }
        return CommonReturnType.create(list);
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
  * 查询供应商信息
  * @return
  */
 @RequestMapping("supplier")
 public CommonReturnType selectAll() throws BusinessException {
  List<SupplierDO> list = supplierService.selectAll();
/* for (SupplierDO supplierDO:list){

 }
  System.out.println(list);*/
  if (list.size()==0){
   throw new BusinessException(EmBusinessError.SUPPLIER_NOT_EXIST);
  }
  return CommonReturnType.create(list);
 }

 /**
 * 查询所有供应商
 */
@RequestMapping("selectSupplier")
public ModelAndView selectSupplier(){
 ModelAndView mv = new ModelAndView("admin-enter");
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
 @RequestMapping("selecthouse")
 public CommonReturnType sr() throws BusinessException {
  List<WareHouseDO> list = wareHouseService.selectAll();
  if (list.size()==0){
   throw new BusinessException(EmBusinessError.CARGO_NOT_EXIST);
  }
  return CommonReturnType.create(list);
 }

/**
 * 显示仓库页面
 */
@RequestMapping("house")
public ModelAndView houseUI(){
 ModelAndView mv = new ModelAndView("house");
 List<WareHouseDO> list = wareHouseService.selectAll();
mv.addObject("houseList",list);
 return mv;
}

/**
 * 跳转出库页面
 */
@RequestMapping(value = "out",method = RequestMethod.GET)
 public ModelAndView out(@RequestParam(value = "houseid")Integer cId, HttpServletRequest request){
 //按货物id查询仓库
 WareHouseDO wareHouseDO = wareHouseService.selectByPrimaryKey(cId);
 List<CustomerDO> list = customerService.selectAll();
 ModelAndView mv  =new ModelAndView("admin-out");
 mv.addObject("wareHouse",wareHouseDO);
 mv.addObject("customerList",list);
 return mv;
}

 /**
  * 出货生成订单ex
  * @param
  * @param
  * @return
  */
@RequestMapping(value = "outOrder",method = RequestMethod.POST)
public CommonReturnType outOrder(@RequestBody OrderDO order) throws BusinessException {
 //生成订单号
 List<WareHouseDO> list = wareHouseService.selectcs(order.getCargoName(),order.getSupplier());
 for (WareHouseDO wareHouseDO:list){
  wareHouseDO.setAmount(wareHouseDO.getAmount()-order.getAmount());
  if (wareHouseDO.getAmount()<0){
   throw new BusinessException(EmBusinessError.OUT_OF_STOCK);
  }else if (wareHouseDO.getAmount()==0){
   wareHouseDO.setState("缺货");
  }
  wareHouseService.updateByPrimaryKeySelective(wareHouseDO);
 }
 String s = KeyUtil.genUniqueKey();
 order.setOrderId(s);
 SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd") ;
 order.setCreateDate(sm.format(new Date()));
 orderService.insertSelective(order);
 return CommonReturnType.create("success");
}


/**
 * 查询订单
 */
@RequestMapping(value = "order",method = RequestMethod.POST)
 public CommonReturnType order() throws BusinessException {
 List<OrderDO> orderDO  = orderService.selectAll();
 if (orderDO.size()==0){
  throw new BusinessException(EmBusinessError.ORDER_NOT_EXIST);
 }
// for (OrderDO orderDO1:orderDO){
//
//     orderDO1.setCreateDate(DateUtil.date(orderDO1.getCreateDate()));
// }
 return CommonReturnType.create(orderDO);
}



}
