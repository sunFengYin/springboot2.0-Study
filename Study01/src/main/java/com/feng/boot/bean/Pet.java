package com.feng.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Pet {
    private String name;
}
