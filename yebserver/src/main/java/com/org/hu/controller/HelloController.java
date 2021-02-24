package com.org.hu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "helloWorld";
    }

    @GetMapping(value = "/employee/basic/hello")
    public String hello2(){
        return  "/employee/basic/hello";
    }

    @GetMapping(value = "/employee/advanced/hello")
    public String hello3(){
        return  "/employee/advanced/hello";
    }
}
