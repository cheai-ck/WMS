package com.wcg.service;

import com.wcg.dataobject.CustomerDO;

import java.util.List;

public interface CustomerService {
    List<CustomerDO> selectAll();
}
