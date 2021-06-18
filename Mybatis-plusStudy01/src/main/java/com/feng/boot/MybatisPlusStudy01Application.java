package com.feng.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.feng.boot.mapper")
public class MybatisPlusStudy01Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusStudy01Application.class, args);
    }

}
