package com.feng.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
//@Component
@ConfigurationProperties(prefix = "mycar")
//在配置文件中进行属性动态配置
//也就是说将里面的属性更配置文件中的属性进行1：1绑定
//适用场景：数据库连接的时候
public class Car {
    private String brand;
    private Integer price;
}
