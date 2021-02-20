package com.org.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.mapper.MenuMapper;
import com.org.hu.pojo.Menu;
import com.org.hu.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
