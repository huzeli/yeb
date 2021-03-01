package com.org.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.org.hu.pojo.Menu;
import com.org.hu.pojo.MenuRole;
import com.org.hu.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
public interface IMenuRoleService extends IService<MenuRole> {

    List<Integer> getMenusIdsByRoleId(Integer id);

    RespBean updateMenusByRoleId(Integer id, Integer[] mids);
}
