package com.wcg.service.impl;

import com.wcg.dao.OrderDOMapper;
import com.wcg.dataobject.OrderDO;
import com.wcg.dataobject.SupplierDO;
import com.wcg.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
 @Resource
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

 @Override
 public List<SupplierDO> selectName(String cargoName) {
  return orderDOMapper.selectName(cargoName);
 }

 @Override
 public List<OrderDO> selectPage(Integer num) {
  int size = 10;
  int start = size * (num - 1);
  return orderDOMapper.selectPage(start, size);
 }
}
