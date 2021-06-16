package com.feng.boot;

import com.feng.boot.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootApplication.class);
        Person bean = run.getBean(Person.class);
        System.out.println(bean);
    }
}
