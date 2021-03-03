package com.org.hu.controller;


import com.org.hu.pojo.RespBean;
import com.org.hu.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.org.hu.pojo.Role;

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
@RequestMapping("/sytem/basic/permiss")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 查询所有角色
     */
    @ApiOperation("查询所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("添加角色")
    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("添加成功");
        }else{
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public RespBean deleteRole(@PathVariable Integer id){
        if(roleService.removeById(id)){
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }
}
