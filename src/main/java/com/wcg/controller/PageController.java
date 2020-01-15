package com.wcg.controller;

import com.wcg.dataobject.CargoDO;
import com.wcg.dataobject.OrderDO;
import com.wcg.response.CommonReturnType;
import com.wcg.service.CargoService;
import com.wcg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController extends BaseController {
    @Autowired
    private CargoService cargoService;
    @Autowired
    private OrderService orderService;

    /**
     * 货物分页查询
     * @param id
     * @return
     */
    @RequestMapping(value = "pageCargo/{id}")
    public CommonReturnType pageCargo(@PathVariable Integer id){
        List<CargoDO> list =cargoService.selectPage(id);
        return CommonReturnType.create(list);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "pageOrder/{num}")
    public CommonReturnType pageOrder(@PathVariable Integer num){
        List<OrderDO> list = orderService.selectPage(num);
        return CommonReturnType.create(list);
    }
}
