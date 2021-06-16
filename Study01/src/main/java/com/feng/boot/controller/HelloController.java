package com.feng.boot.controller;

import com.feng.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody //返回指定的格式。写入到response对象的body区
//@Controller
//@RestController 包含上面两个注解
@RestController
@Slf4j//日志
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping(value = "/hello")
    public String handle01(){
        return "Hello ,SpringBoot 2!";
    }

    @RequestMapping(value = "/car")
    public Car hadnle02(){
        log.info("请求进来了");
        return car;
    }
}
