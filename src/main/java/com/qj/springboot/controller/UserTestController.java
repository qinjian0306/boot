package com.qj.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qj.springboot.bean.UserTest;
import com.qj.springboot.jsonview.View;
import com.qj.springboot.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserTestController {

    @Autowired
    private UserTestService userTestService;

//    @JsonView(View.Common.class)
//    @JsonView(View.Ext.class)
    @JsonView(View.Deal.class)
    @RequestMapping("/userTest")
    public Object getUser(){
        List<UserTest> list =  userTestService.getUserList();
        return list;
    }

    @RequestMapping("/userById")
    public Object getUserById(){
        UserTest userTest =  userTestService.getUserById(2);
        return userTest;
    }
}
