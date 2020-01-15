package com.wcg.service.impl;

import com.wcg.dao.SupplierDOMapper;
import com.wcg.dataobject.SupplierDO;
import com.wcg.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {

 @Resource
 private SupplierDOMapper supplierDOMapper;

 public int deleteByPrimaryKey(Integer supplierId) {
  return supplierDOMapper.deleteByPrimaryKey(supplierId);
 }

 @Override
 public int insert(SupplierDO record) {
  return 0;
 }

 @Override
 public int insertSelective(SupplierDO record) {
  return 0;
 }

 @Override
 public SupplierDO selectByPrimaryKey(Integer supplierId) {
  return supplierDOMapper.selectByPrimaryKey(supplierId);
 }

 @Override
 public List<SupplierDO> selectAll() {
  return supplierDOMapper.selectAll();
 }

 @Override
 public List<SupplierDO> selectName(String supplierName) {
  return supplierDOMapper.selectName(supplierName);
 }

 @Override
 public int updateByPrimaryKeySelective(SupplierDO record) {
  return 0;
 }

 @Override
 public int updateByPrimaryKey(SupplierDO record) {
  return 0;
 }
}
