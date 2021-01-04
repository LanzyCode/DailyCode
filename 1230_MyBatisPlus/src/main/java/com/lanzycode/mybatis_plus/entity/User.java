package com.lanzycode.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName
@Data
public class User {
    private Long id;
    private String primary;
    private String user_name;
    private String password;
    private String name;
    private Integer age;
    private String email;
}
