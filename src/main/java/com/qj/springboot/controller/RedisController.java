package com.qj.springboot.controller;

import com.qj.springboot.redis.JedisCli;
import com.qj.springboot.redis.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis测试
 */
@RestController
public class RedisController {


    @Autowired
    private RedisProperties redisProperties;

    @Autowired
    private JedisCli jedisCli;


    @RequestMapping("/redis")
    public String redis(){
        System.out.println(redisProperties.toString());
        return "redis";
    }

    @RequestMapping("/key")
    public String key(){
        jedisCli.setNoExpire("key3","30");
        System.out.println(jedisCli.get("key3"));
        return "key";
    }
}
