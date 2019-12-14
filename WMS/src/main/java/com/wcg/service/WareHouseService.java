package com.wcg.service;

import com.wcg.dataobject.WareHouseDO;

import java.util.List;

public interface WareHouseService {
 int deleteByPrimaryKey(Integer houseId);

 int insert(WareHouseDO record);

 int insertSelective(WareHouseDO record);

 WareHouseDO selectByPrimaryKey(Integer houseId);

 //查询库存中是否有该货物
 List<WareHouseDO> selectcs(String cName, String SName);

 List<WareHouseDO> selectAll();

 int updateByPrimaryKeySelective(WareHouseDO record);

 int updateByPrimaryKey(WareHouseDO record);
}
