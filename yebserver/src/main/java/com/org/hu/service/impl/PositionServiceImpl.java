package com.org.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.mapper.PositionMapper;
import com.org.hu.pojo.Position;
import com.org.hu.service.IPositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

}
