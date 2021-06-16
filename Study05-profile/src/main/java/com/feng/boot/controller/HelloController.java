package com.feng.boot.controller;

import com.feng.boot.entity.Color;
import com.feng.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name:李四}")
    private String name;

    @Autowired
    private Person person;

    @Autowired
    private Color color;
    @GetMapping("/")
    public String hello(){
        System.out.println(name);
        return person.getClass().toString()+
                "------>"+
                color.getColor()+
                person.getName()+
                " : "+
                person.getAge();
    }
}
