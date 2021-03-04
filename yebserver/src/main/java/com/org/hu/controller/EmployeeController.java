package com.org.hu.controller;


import com.org.hu.pojo.Employee;
import com.org.hu.pojo.RespPageBean;
import com.org.hu.service.IEmployeeEcService;
import com.org.hu.service.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @ApiOperation("获取所有员工（分页）")
    @GetMapping("/")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer size , Employee employee, @RequestParam(required = false) LocalDate[] beginDateScope){
        return  employeeService.getEmployee(currentPage,size,employee,beginDateScope);
    }
}
