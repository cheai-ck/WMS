package com.wcg.service;

import com.wcg.dataobject.OrderDO;

import java.util.List;

public interface OrderService {
 int deleteByPrimaryKey(Integer id);

 int insert(OrderDO record);

 int insertSelective(OrderDO record);

 List<OrderDO> selectAll();

 OrderDO selectByPrimaryKey(Integer id);

 int updateByPrimaryKeySelective(OrderDO record);

 int updateByPrimaryKey(OrderDO record);
}
