package com.wcg.dao;

import com.wcg.dataobject.CargoDO;

import java.util.List;

public interface CargoDOMapper {
    int deleteByPrimaryKey(Integer cargoId);

    int insert(CargoDO record);

    int insertSelective(CargoDO record);

    List<CargoDO> selectAll();

    List<CargoDO> selectName(String cargoName);

    CargoDO selectByPrimaryKey(Integer cargoId);

    int updateByPrimaryKeySelective(CargoDO record);

    int updateByPrimaryKey(CargoDO record);

    List<CargoDO> selectPage(Integer start,Integer size);

}