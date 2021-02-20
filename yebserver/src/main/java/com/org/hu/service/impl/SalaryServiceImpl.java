package com.org.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.mapper.SalaryMapper;
import com.org.hu.pojo.Salary;
import com.org.hu.service.ISalaryService;
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
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {

}
