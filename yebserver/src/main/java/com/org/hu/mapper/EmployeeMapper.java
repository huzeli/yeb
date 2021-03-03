package com.org.hu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.org.hu.pojo.Employee;
import io.lettuce.core.dynamic.annotation.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 获取所有员工分页
     * @param page
     * @param employee
     * @param size
     * @return
     */
    IPage<Employee> getEmployeeByPage(Page<Employee> page, @Param("employee") Employee employee,@Param("beginDateScope") LocalDate[] beginDateScope);
}
