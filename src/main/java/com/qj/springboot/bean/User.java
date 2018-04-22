package com.qj.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
//@Validated
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    @NonNull
    private String name;
    private Integer age;
    // 0 未知 1男 2女
    private Integer sex;
}
