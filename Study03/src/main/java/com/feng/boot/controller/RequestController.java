package com.feng.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @RequestMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg","success@!");
        request.setAttribute("code",200);
        return "forward:/success";//forward表示转发
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        Object msg1=request.getAttribute("msg");
        map.put("reqMethod_msg",msg1);
        map.put("annotation_msg",msg);
        return map;
    }

    // 1.语法   /cars/sell;low=34;brand=byd,audi,yd
    // SpringBoot默认是关闭的，
    @RequestMapping("/cars/{path}")
    @ResponseBody
    public Map sellCar(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path){
        Map<String,Object> map=new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello","hello666");
        model.addAttribute("model","model66");
        request.setAttribute("msg","request666");
        Cookie cookie = new Cookie("sun","fight");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success2";
    }

    @RequestMapping("/success2")
    @ResponseBody
    public Map success2(HttpServletRequest request){
        Object hello = request.getAttribute("hello");
        Object mode=request.getAttribute("model");
        Object msg=request.getAttribute("msg");

        Map<String,Object> map=new HashMap<>();
        map.put("hello",hello);
        map.put("mode",mode);
        map.put("msg",msg);
        return map;

    }
}
