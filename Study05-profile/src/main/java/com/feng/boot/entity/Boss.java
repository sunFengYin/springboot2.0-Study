package com.feng.boot.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
@Data
@ConfigurationProperties("person")
public class Boss implements Person{
    private String name;
    private Integer age;

}
