package com.org.hu.controller;

import com.org.hu.pojo.Admin;
import com.org.hu.pojo.AdminLoginParam;
import com.org.hu.pojo.RespBean;
import com.org.hu.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private IAdminService adminService;
    @ApiOperation(value = "登录成功返回token")
    @RequestMapping("/login")
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request, HttpServletResponse response){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping("/admin/info")
    public RespBean getAdminInfo(Principal principal){
        if(principal==null){
            return null;
        }
        String username=principal.getName();
       Admin admin= adminService.getAdminInfo(username);
       admin.setPassword(null);
    }

    @ApiOperation(value = "注销登录")
    @RequestMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功");
    }
}
