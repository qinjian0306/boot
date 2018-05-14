package com.qj.springboot.service.impl;

import com.qj.springboot.bean.UserTest;
import com.qj.springboot.mapper.UserTestMapper;
import com.qj.springboot.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named("userTestService2Impl")
public class UserTestService2Impl implements UserTestService {

    @Autowired
    private UserTestMapper userTestMapper;

    @Override
    public List<UserTest> getUserList() {
       List<UserTest> userTestList =  userTestMapper.getUserList();
        return userTestList;
    }

    @Override
    public UserTest getUserById(Integer id) {
        UserTest userTest =  userTestMapper.getUserById(2);
        return userTest;
    }

}
