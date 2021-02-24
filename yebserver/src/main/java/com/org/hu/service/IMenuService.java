package com.org.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.org.hu.pojo.Menu;
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
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenusBtAdminId();

    List<Menu> getMenusWithRole();
}
