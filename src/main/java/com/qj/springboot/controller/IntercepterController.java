package com.qj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器controller
 */
@RestController
public class IntercepterController {
    @RequestMapping("/interceper")
    public String interceper(){
        System.out.println("通过拦截器");
        return "interceper";
    }
}
