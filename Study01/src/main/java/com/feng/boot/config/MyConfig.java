package com.feng.boot.config;

import com.feng.boot.bean.Car;
import com.feng.boot.bean.Pet;
import com.feng.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      full(proxyBeanMethods = true) 生成代理对象，是单例的
 *      lite(proxyBeanMethods = false) 不是代理对象，每次调用都是新生成。
 *          也就是说，spring不会检查容器中是否有这个东西，每次都是新生成
 *      所以full速度<lite速度！！！
 */
//@Import({DBAppender.class, DateDeserializers.SqlDateDeserializer.class})//给容器导入相应的组件（实例）
@Configuration(proxyBeanMethods = true)//这是一个SpringBoot的配置类，等于配置文件XML
@ImportResource("classpath:beans.xml")//导入指定XML文件。
@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能
//2、把这个Car组件自动注册到容器中
public class MyConfig {

    //创建的是单实例的
    @Bean//给容器中添加组件，方法名就是id。返回类型就是组件类型，返回的值，就是组件在容器中的实例
    @ConditionalOnBean(name="tom")//满足条件才进行注入。这个条件是容器中有tom实例时才进行
    public User user01(){
        return User.builder().name("zhangsan").age(20).pet( pet01()).build();
    }

    @Bean("tom")//自定义id
    public Pet pet01(){
        return Pet.builder().name("tomcat").build();
    }
}
