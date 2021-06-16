package com.feng.boot.config;

import com.feng.boot.entity.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfig {

    @Profile("prod")
    @Bean
    public Color red(){
        return  Color.
                builder().
                color("red").
                build();
    }


    @Profile("test")
    @Bean
    public Color green(){
        return  Color.
                builder().
                color("greed").
                build();
    }
}
