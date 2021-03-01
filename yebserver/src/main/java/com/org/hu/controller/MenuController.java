package com.org.hu.controller;


import com.org.hu.pojo.Menu;
import com.org.hu.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@RestController
@RequestMapping("/system")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId(){
        return menuService.getMenusBtAdminId();
    }

//    @ApiOperation("查询所有菜单")
//    @GetMapping("")
//    public List<Menu> getAllMenus(){
//        return menuService.getAllMenus();
//    }

}
