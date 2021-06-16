package com.feng.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {


    @GetMapping("/atgoto")
    public String atgoto(Model model){
        model.addAttribute("msg","你好呀！！！");
        model.addAttribute("link"," ://www.bing.com");
        return "success3";
    }
}
