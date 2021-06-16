package com.feng.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
//@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyListener:开始了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        log.info("MyListener:销毁了");
    }
}
