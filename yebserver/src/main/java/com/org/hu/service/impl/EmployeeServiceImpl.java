package com.org.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.mapper.EmployeeMapper;
import com.org.hu.pojo.Employee;
import com.org.hu.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
