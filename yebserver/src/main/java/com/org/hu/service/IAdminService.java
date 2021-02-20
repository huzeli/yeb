package com.org.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.org.hu.pojo.Admin;
import com.org.hu.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminInfo(String username);
}
