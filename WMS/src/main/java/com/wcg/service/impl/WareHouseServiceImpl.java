package com.wcg.service.impl;

import com.wcg.dao.WareHouseDOMapper;
import com.wcg.dataobject.WareHouseDO;
import com.wcg.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseServiceImpl implements WareHouseService {
 @Autowired
 private WareHouseDOMapper wareHouseDOMapper;

 @Override
 public int deleteByPrimaryKey(Integer houseId) {
  return 0;
 }

 @Override
 public int insert(WareHouseDO record) {
  return wareHouseDOMapper.insert(record);
 }

 @Override
 public int insertSelective(WareHouseDO record) {
  return wareHouseDOMapper.insertSelective(record);
 }

 @Override
 public WareHouseDO selectByPrimaryKey(Integer houseId) {
  return wareHouseDOMapper.selectByPrimaryKey(houseId);
 }

 @Override
 public List<WareHouseDO> selectcs(String cName, String sName) {
  return wareHouseDOMapper.selectcs(cName,sName);
 }

 @Override
 public List<WareHouseDO> selectAll() {
  return wareHouseDOMapper.selectAll();
 }

 @Override
 public int updateByPrimaryKeySelective(WareHouseDO record) {
  return wareHouseDOMapper.updateByPrimaryKeySelective(record);
 }

 @Override
 public int updateByPrimaryKey(WareHouseDO record) {
  return 0;
 }
}
