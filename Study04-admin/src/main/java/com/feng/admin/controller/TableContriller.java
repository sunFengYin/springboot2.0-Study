package com.feng.admin.controller;


import com.feng.admin.entity.User;
import com.feng.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class TableContriller {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int b =1/0;
        return "table/basic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){

        List<User> list = userService.list();
        log.info("共有：{}",list);
        model.addAttribute("users",list);
        return "table/dynamic_table";
    }


}
