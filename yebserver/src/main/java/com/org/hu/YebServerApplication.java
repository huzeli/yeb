package com.org.hu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.org.hu.mapper")
public class YebServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebServerApplication.class,args);
    }
}
