package com.wcg.realm;

import com.wcg.dataobject.AdminDO;
import com.wcg.error.BusinessException;
import com.wcg.error.EmBusinessError;
import com.wcg.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;
    private static Logger logger = LoggerFactory.getLogger(UserRealm.class);

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.debug("进行认证逻辑");
        UsernamePasswordToken uptoken =(UsernamePasswordToken) token;
        //用户名
        String username =(String)uptoken.getPrincipal();
        //密码
        String password = new String((char[])uptoken.getCredentials());
        AdminDO adminDO = adminService.selectLogin(username,password);
        if (adminDO==null){
            throw new UnknownAccountException();
            //throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        AuthenticationInfo info =new SimpleAuthenticationInfo(username,adminDO.getManagementPass(),getName());
        return info;
    }
}
