package com.qj.springboot.controller;

import com.qj.springboot.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/configuration")
    public String configuration(){
        System.out.println(dataSource.toString());
        return dataSource.toString();

    }
}
