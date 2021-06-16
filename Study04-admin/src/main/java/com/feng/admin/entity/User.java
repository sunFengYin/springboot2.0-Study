package com.feng.admin.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;



    private Long id;
    private String name;
    private Integer age;
    private String email;
}
