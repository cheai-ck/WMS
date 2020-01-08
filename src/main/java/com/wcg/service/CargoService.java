package com.wcg.service;

import com.wcg.dataobject.CargoDO;

import java.util.List;

public interface CargoService {
 int deleteByPrimaryKey(Integer cargoId);

 int insert(CargoDO record);

 int insertSelective(CargoDO record);

 List<CargoDO> selectName(String cargoName);

 List<CargoDO> selectAll();

 CargoDO selectByPrimaryKey(Integer cargoId);

 int updateByPrimaryKeySelective(CargoDO record);

 int updateByPrimaryKey(CargoDO record);


}
