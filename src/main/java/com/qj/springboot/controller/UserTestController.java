package com.qj.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qj.springboot.bean.UserTest;
import com.qj.springboot.jsonview.View;
import com.qj.springboot.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RestController
public class UserTestController {

    @Inject
    @Named("userTestServiceImpl")
    private UserTestService userTestService;

//    @Inject
//    @Named("userTestService2Impl")
//    private UserTestService userTestService;

    @JsonView(View.Deal.class)
    @RequestMapping("/userTest")
    public Object getUser(){
        List<UserTest> list =  userTestService.getUserList();
        return list;
    }

    @RequestMapping("/userById")
    public Object getUserById(){
        UserTest userTest =  userTestService.getUserById(1);
        return userTest;
    }
}
