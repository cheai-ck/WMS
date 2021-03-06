package com.wcg.dao;

import com.wcg.dataobject.OrderDO;
import com.wcg.dataobject.SupplierDO;

import java.util.List;

public interface OrderDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    List<OrderDO> selectAll();

    OrderDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);

    List<SupplierDO> selectName(String cargoName);

    List<OrderDO> selectPage(Integer start,Integer size);
}