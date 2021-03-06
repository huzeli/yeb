package com.org.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.org.hu.pojo.Employee;
import com.org.hu.pojo.RespPageBean;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
public interface IEmployeeService extends IService<Employee> {

    RespPageBean getEmployee(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);
}
