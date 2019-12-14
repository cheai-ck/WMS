package com.wcg.service.impl;

import com.wcg.dao.OrderDOMapper;
import com.wcg.dataobject.OrderDO;
import com.wcg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
 @Autowired
 private OrderDOMapper  orderDOMapper;
 @Override
 public int deleteByPrimaryKey(Integer id) {
  return 0;
 }

 @Override
 public int insert(OrderDO record) {
  return 0;
 }

 @Override
 public int insertSelective(OrderDO record) {
  return orderDOMapper.insertSelective(record);
 }

 @Override
 public List<OrderDO> selectAll() {
  return orderDOMapper.selectAll();
 }

 @Override
 public OrderDO selectByPrimaryKey(Integer id) {
  return null;
 }

 @Override
 public int updateByPrimaryKeySelective(OrderDO record) {
  return 0;
 }

 @Override
 public int updateByPrimaryKey(OrderDO record) {
  return 0;
 }
}
