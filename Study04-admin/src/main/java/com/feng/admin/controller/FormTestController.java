package com.feng.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "/form/form_layouts";
    }

    /**
     * 文件上传
     * @param email
     * @param username
     * @param headImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
        log.info("上传信息：email={},username={},headimg={},photos={}",email,username,headImg.getSize(),photos.length);

        //文件保存
        if(!headImg.isEmpty()){
            String originalFilename = headImg.getOriginalFilename();
            headImg.transferTo(new File("/Users/sun/Documents"+originalFilename));
        }
        if(photos.length>0){
            for(MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("/Users/sun/Documents"+originalFilename));
                }
            }
        }
        return "main";

    }
}
