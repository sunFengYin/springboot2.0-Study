package com.feng.boot.controller;

import com.feng.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@Controller
//@ResponseBody
//跟上面两个相等
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping(value = "/person")
    public Person helloPerson(){
        return person;
    }
}
