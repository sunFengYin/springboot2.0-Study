package com.feng.mybatisplusgenerator.controller;


import com.feng.mybatisplusgenerator.entity.User;
import com.feng.mybatisplusgenerator.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunfengyin
 * @since 2021-06-18
 */
@RestController

public class UserController {

    @Autowired
    private IUserService iUserService;


    //测试代码生成的
    @GetMapping("/user")
    public String test(){
        List<User> list = iUserService.list();
        return list.toString();
    }
    //测试自己写的sql
    @GetMapping("/user/{id}")
    public User byId(@PathVariable("id") Long id){
        return iUserService.getbyId(id);
    }

    @GetMapping("/myuser")
    public List<User> myuser(){

        return iUserService.myFindAllUser();
    }
}
