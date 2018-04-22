package com.qj.springboot.service;

import com.qj.springboot.bean.UserTest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserTestService {
    List<UserTest> getUserList();
    UserTest getUserById(Integer id);
}
