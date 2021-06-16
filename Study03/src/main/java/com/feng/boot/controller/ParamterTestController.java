package com.feng.boot.controller;

import com.feng.boot.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamterTestController {

    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }



    @GetMapping(value = "/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("interests") List<String> interests){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("User-Agent",userAgent);
        map.put("headers ",header);
        map.put("age",age);
        map.put("interests",interests);
        return map ;
    }


    @PostMapping("/save")
    public Map<String,Object> postMethod(@RequestBody String content){
        Map<String,Object> map=new HashMap<>();
        map.put("content",content);
        return map;
    }
}
