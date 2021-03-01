package com.org.hu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.mapper.MenuRoleMapper;
import com.org.hu.pojo.Menu;
import com.org.hu.pojo.MenuRole;
import com.org.hu.pojo.RespBean;
import com.org.hu.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;
    @Override
    public List<Integer> getMenusIdsByRoleId(Integer rid) {
        return menuRoleMapper.getMenusIdsByRoleId(rid);
    }

    @Override
    @Transactional
    public RespBean updateMenusByRoleId(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if(null==mids||0==mids.length){
            return RespBean.success("更新成功");
        }
       Integer reslut= menuRoleMapper.inserRecord(rid,mids);
        if(reslut==mids.length){
            return RespBean.success("更新成功");
        }else{
            return RespBean.success("更新失败");
        }

    }
}
