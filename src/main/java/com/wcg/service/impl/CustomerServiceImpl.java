package com.wcg.service.impl;

import com.wcg.dao.CustomerDoMapper;
import com.wcg.dataobject.CustomerDO;
import com.wcg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDoMapper customerDoMapper;
    @Override
    public List<CustomerDO> selectAll() {
        return customerDoMapper.selectAll();
    }
}
