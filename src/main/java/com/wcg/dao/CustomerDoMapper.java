package com.wcg.dao;

import com.wcg.dataobject.CustomerDO;

import java.util.List;

public interface CustomerDoMapper {
    List<CustomerDO> selectAll();

    int deleteByPrimaryKey(Integer supplier);
}
