package com.qj.springboot.service.impl;

import com.qj.springboot.bean.UserTest;
import com.qj.springboot.mapper.UserTestMapper;
import com.qj.springboot.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private UserTestMapper userTestMapper;

    @Override
    public List<UserTest> getUserList() {
       List<UserTest> userTestList =  userTestMapper.getUserList();
        return userTestList;
    }

    @Override
    public UserTest getUserById(Integer id) {
        UserTest userTest =  userTestMapper.getUserById(id);
        return userTest;
    }

}
