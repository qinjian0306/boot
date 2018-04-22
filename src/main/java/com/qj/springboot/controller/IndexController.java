package com.qj.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${age}")
    private Integer age;



    @RequestMapping("/login")
    public String login(){
        return "login";

    }

    @RequestMapping("/index")
    public String index(){
        return "spring-boot index";
    }

    @RequestMapping("/index2")
    public String index2(){
        return "spring-boot index2";

    }

    @RequestMapping("/testVal")
    public String testVal(){
        System.out.println("username:" + username + "password:" + password + "age:"+age);
        return "spring-boot testVal";
    }

}
