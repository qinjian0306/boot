package com.qj.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qj.springboot.bean.UserTest;
import com.qj.springboot.jsonview.View;
import com.qj.springboot.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonViewController {

    @Autowired
    private UserTestService userTestService;

    @JsonView(View.Deal.class)
    @RequestMapping("/jsonView")
    public Object jsonView(){
        List<UserTest> list = userTestService.getUserList();
        return list;
    }


    @RequestMapping("/jsonToPojo")
    public String jsonView(@RequestBody UserTest userTest){
        return userTest.toString();
    }

}
