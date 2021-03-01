package com.org.hu.controller;

import com.org.hu.pojo.Menu;
import com.org.hu.pojo.RespBean;
import com.org.hu.service.IMenuRoleService;
import com.org.hu.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermisssController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation("查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenu(){
        return menuService.getAllMenus();
    }

    @ApiOperation("根据角色ID查询菜单列表")
    @GetMapping("mid/{id}")
    public List<Integer> getMenusIdByRoleId(@PathVariable Integer id){
        return menuRoleService.getMenusIdsByRoleId(id);
    }

    @ApiOperation("更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenusByRoleId(Integer id,Integer[] mids){
       return menuRoleService.updateMenusByRoleId(id,mids);
    }
}
