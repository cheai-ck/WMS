package com.wcg.dao;

import com.wcg.dataobject.SupplierDO;

import java.util.List;

public interface SupplierDOMapper {
    int deleteByPrimaryKey(Integer supplierId);

    int insert(SupplierDO record);

    int insertSelective(SupplierDO record);

    List<SupplierDO> selectAll();

    List<SupplierDO> selectName(String supplierName);

    SupplierDO selectByPrimaryKey(Integer supplierId);

    int updateByPrimaryKeySelective(SupplierDO record);

    int updateByPrimaryKey(SupplierDO record);
}