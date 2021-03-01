package com.org.hu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.org.hu.pojo.MenuRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
   List<Integer> getMenusIdsByRoleId(Integer rid);

    Integer inserRecord(Integer rid, Integer[] mids);
}
