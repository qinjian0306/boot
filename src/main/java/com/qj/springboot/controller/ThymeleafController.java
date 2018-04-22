package com.qj.springboot.controller;

import com.qj.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController {

//    @GetMapping("thymeleafTest")   相当于@RequestMapping(method = RequestMethod.GET)
    @RequestMapping("thtest")
    public String thymeleafTest(Model model){
        List<User> userList = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();
        User user1  = new User("哈哈");
        user1.setAge(18);
        user1.setSex(1);
        User user2 = new User("呵呵");
        user2.setAge(20);
        user2.setSex(0);
        User user3 = new User("嘿嘿");
        user3.setAge(23);
        user3.setSex(0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        model.addAttribute("user",user1);
        model.addAttribute("userList",userList);
        model.addAttribute("userList2",userList2);
        model.addAttribute("time",new Date());
        return "/thymeleaf/hello";
    }

}
