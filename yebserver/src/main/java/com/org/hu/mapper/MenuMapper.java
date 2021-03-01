package com.org.hu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.org.hu.pojo.Menu;
import com.org.hu.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusAdminId(Integer id);

    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
