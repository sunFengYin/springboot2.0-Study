package com.feng.boot;

import ch.qos.logback.classic.db.DBAppender;
import com.feng.boot.bean.Pet;
import com.feng.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //固定写法，启动类
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);

//        //SpringBoot总会检查这个实例是否有，如果有，那拿来。否则就新创建。
//        Pet tom = run.getBean("tom", Pet.class);
//        Pet tom1 = run.getBean("tom", Pet.class);
//        System.out.println(tom1==tom1);


//        User user01 = run.getBean("user01", User.class);
//        System.out.println(user01);

        //测试@Conditional
        //判断是否有这个实例
        boolean tom = run.containsBean("tom");
        System.out.println(tom);
        boolean user01 = run.containsBean("user01");
        System.out.println(user01);

        System.out.println("==========");
        System.out.println(run.containsBean("hh"));
        System.out.println(run.containsBean("hehe"));

    }
}
