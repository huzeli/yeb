package com.org.hu.config.security.component;

import com.org.hu.pojo.RespBean;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionCommonHandler{

    @ExceptionHandler(SQLException.class)
    public RespBean mysqlExceptionHander(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据存在关联关系，不能操作");
        }
        return RespBean.error("数据库异常");
    }

}
