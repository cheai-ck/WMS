package com.wcg.service.impl;

import com.wcg.dao.AdminDOMapper;
import com.wcg.dataobject.AdminDO;
import com.wcg.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
@Resource
 private AdminDOMapper adminDOMapper;
 @Override
 public int deleteByPrimaryKey(Integer managementId) {
  return 0;
 }

 @Override
 public int insert(AdminDO record) {
  return 0;
 }

 @Override
 public int insertSelective(AdminDO record) {
  return 0;
 }

 @Override
 public AdminDO selectByPrimaryKey(Integer managementId) {

  return adminDOMapper.selectByPrimaryKey(managementId);
 }

 @Override
 public int updateByPrimaryKeySelective(AdminDO record) {
  return 0;
 }

 @Override
 public int updatePass(String managementUser, String password) {
  return adminDOMapper.updatePass(managementUser,password);
 }


 @Override
 public AdminDO selectLogin(String managementUser, String managementPass) {
  AdminDO adminDO = adminDOMapper.selectLogin(managementUser,managementPass);
  if (adminDO==null){
   return null;
  }
  return adminDO;
 }
}
