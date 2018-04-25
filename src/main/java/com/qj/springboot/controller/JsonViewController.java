package com.qj.springboot.controller;

import com.alibaba.fastjson.JSONObject;
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

//    private UserTest.Password user;

    @JsonView(UserTest.User.class)
    @RequestMapping("/jsonView")
    public JSONObject jsonView(){
        JSONObject jsonObject = new JSONObject();
        List<UserTest> list = userTestService.getUserList();
//        user = (UserTest.Password)(list.get(0));
        jsonObject.put("userList",list.get(0));
//        jsonObject.put("user",user);
        return jsonObject;
    }

}
