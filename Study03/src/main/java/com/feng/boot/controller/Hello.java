package com.feng.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {



//    @RequestMapping(value = "/user",method = RequestMethod.GET)//跟底下的相等！！
    @GetMapping("/user")
    public String getUser(){
        return "GET!";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String postUser(){
        return "POST";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE";
    }
}
