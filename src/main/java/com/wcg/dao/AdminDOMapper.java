package com.wcg.dao;

import com.wcg.dataobject.AdminDO;
import org.apache.ibatis.annotations.Param;

public interface AdminDOMapper {
    int deleteByPrimaryKey(Integer managementId);

    int insert(AdminDO record);

    int insertSelective(AdminDO record);

    AdminDO selectByPrimaryKey(Integer managementId);

    int updateByPrimaryKeySelective(AdminDO record);

    int updateByPrimaryKey(AdminDO record);

    AdminDO selectLogin(@Param("managementUser") String managementUser, @Param("managementPass")String managementPass);

    int updatePass(@Param("managementUser") String managementUser,@Param(value = "password")String password);
}