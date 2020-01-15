package com.wcg.service.impl;

import com.wcg.dao.CargoDOMapper;
import com.wcg.dataobject.CargoDO;
import com.wcg.service.CargoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
 @Resource
 private CargoDOMapper cargoDOMapper;
 @Override
 public int deleteByPrimaryKey(Integer cargoId) {
  return cargoDOMapper.deleteByPrimaryKey(cargoId);
 }

 @Override
 public int insert(CargoDO record) {
  return 0;
 }

 @Override
 public int insertSelective(CargoDO record) {
  return 0;
 }

 @Override
 public List<CargoDO> selectName(String caogoName) {
  return cargoDOMapper.selectName(caogoName);
 }

 @Override
 public List<CargoDO> selectAll() {
  return cargoDOMapper.selectAll();
 }

 @Override
 public CargoDO selectByPrimaryKey(Integer cargoId) {
  return cargoDOMapper.selectByPrimaryKey(cargoId);
 }

 @Override
 public int updateByPrimaryKeySelective(CargoDO record) {
  return 0;
 }

 @Override
 public int updateByPrimaryKey(CargoDO record) {
  return 0;
 }

 @Override
 public List<CargoDO> selectPage(Integer id) {
  int size = 4;
  int start = size * (id - 1);
  return cargoDOMapper.selectPage(start, size);
 }


}
