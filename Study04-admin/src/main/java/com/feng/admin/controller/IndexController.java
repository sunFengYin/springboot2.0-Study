package com.feng.admin.controller;

import com.feng.admin.entity.City;
import com.feng.admin.entity.User;
import com.feng.admin.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    CityServiceImpl cityServiceImpl;

    @ResponseBody
    @GetMapping("/city")
    public City getCityByid(@RequestParam("id") Long id){
        return cityServiceImpl.getById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String qureyDB(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(!StringUtils.isEmpty(user.getUserName())&&"110".equals(user.getPassword())){
            session.setAttribute("login",user);
            //防止表单重复提交
            //重定向
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账户密码错误");
        return "login";
    }

    /**
     * 主页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //拦截器
        Object loginUser=session.getAttribute("login");
        if(loginUser!=null){
            return "main";
        }

        model.addAttribute("msg","请重新登录");
        return "login";

    }
}
