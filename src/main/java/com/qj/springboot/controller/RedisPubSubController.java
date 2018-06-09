package com.qj.springboot.controller;

import com.qj.springboot.redis.pubsub.PubClient;
import com.qj.springboot.redis.pubsub.SubClient;
import com.qj.springboot.redis.single.JedisCli;
import com.qj.springboot.redis.pubsub.PubSubListener;
import com.qj.springboot.redis.single.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * redis测试
 */
@RestController
public class RedisPubSubController{

    // 单机
    @Autowired
    private JedisCli jedisCli;



    @Autowired
    private PubClient pubClient;
    @Autowired
    private SubClient subClient;
    @Autowired
    private PubSubListener pubSubListener;

    @RequestMapping("/pub")
    public String pub(){

        pubClient.publish("pub test" , "pub test");

        return "pub";
    }

    @RequestMapping("/sub")
    public String sub(){

        subClient.setChannelAndPubsub(pubSubListener,"pub test");
        // 启动
        subClient.start();

        return "sub";
    }

}
