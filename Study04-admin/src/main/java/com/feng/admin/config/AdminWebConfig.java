package com.feng.admin.config;

import com.feng.admin.intercepter.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1.编写一个拦截器实现HandlrInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3.指定拦截规则[如果是所有拦截，静态资源也会被拦截]
 */
@Slf4j
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")///**拦截所有，把静态资源也拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//放行的方法，第一种
    }
}
