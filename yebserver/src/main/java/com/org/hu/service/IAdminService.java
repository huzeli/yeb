package com.org.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.org.hu.pojo.Admin;
import com.org.hu.pojo.Menu;
import com.org.hu.pojo.RespBean;
import com.org.hu.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminInfo(String username);

    /**
     * 根据用户Id 查询用户角色
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

}
