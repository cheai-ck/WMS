package com.wcg.service;

import com.wcg.dataobject.AdminDO;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
 int deleteByPrimaryKey(Integer managementId);

 int insert(AdminDO record);

 int insertSelective(AdminDO record);

 AdminDO selectByPrimaryKey(Integer managementId);

 int updateByPrimaryKeySelective(AdminDO record);

 int updatePass(@Param("managementUser") String managementUser, @Param(value = "password") String password);

 AdminDO selectLogin(@Param("managementUser") String managementUser, @Param("managementPass") String managementPass);
}
