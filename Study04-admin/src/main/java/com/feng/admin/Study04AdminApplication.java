package com.feng.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.feng.admin.mapper")
@ServletComponentScan(basePackages = "com.feng")
@SpringBootApplication
public class Study04AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Study04AdminApplication.class, args);
    }

}
