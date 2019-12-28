package com.wcg.service;


import com.wcg.dataobject.SupplierDO;

import java.util.List;

public interface SupplierService {
 int deleteByPrimaryKey(Integer supplierId);

 int insert(SupplierDO record);

 int insertSelective(SupplierDO record);

 SupplierDO selectByPrimaryKey(Integer supplierId);

 List<SupplierDO> selectAll();

 List<SupplierDO> selectName(String supplierName);

 int updateByPrimaryKeySelective(SupplierDO record);

 int updateByPrimaryKey(SupplierDO record);
}
