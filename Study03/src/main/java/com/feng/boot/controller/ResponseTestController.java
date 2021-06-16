package com.feng.boot.controller;

import com.feng.boot.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    @GetMapping("/test/person")
    @ResponseBody
    public Person getPerson(){
        return Person.builder().
                age(28).
                birth(new Date()).
                userName("tom").
                build();
    }
}
