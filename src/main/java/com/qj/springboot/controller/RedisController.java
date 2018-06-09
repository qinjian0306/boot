package com.qj.springboot.controller;

import com.qj.springboot.redis.cluster.JedisClusterCli;
import com.qj.springboot.redis.cluster.RedisClusterProperties;
import com.qj.springboot.redis.single.JedisCli;
import com.qj.springboot.redis.single.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * redis测试
 */
@RestController
public class RedisController {


    @Autowired
    private RedisProperties redisProperties;
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    // 单机
    @Autowired
    private JedisCli jedisCli;

    // 集群
//    @Autowired
//    private JedisClusterCli jedisClusterCli;


    @RequestMapping("/redis")
    public String redis(){
        System.out.println(redisProperties.toString());
        return "redis";
    }

    @RequestMapping("/key")
    public String key(){
        jedisCli.setNoExpire("kiss","me");
        System.out.println(jedisCli.get("kiss"));
        return "key";
    }

    /**
     * redis集群测试
     * @return
     */
    @RequestMapping("/redisCluster")
    public String redisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.123.83",6381));
        nodes.add(new HostAndPort("192.168.123.83",6382));
        nodes.add(new HostAndPort("192.168.123.83",6383));
        JedisCluster jedisCluster = new JedisCluster(nodes);

        jedisCluster.set("haha","哈哈");
        System.out.println(jedisCluster.get("haha"));

        return "redisCluster";
    }

    /**
     * redis集群测试
     * @return
     */
    /*@RequestMapping("/redisCluster2")
    public String redisCluster2(){

        System.out.println(redisClusterProperties.toString());
        System.out.println(jedisCluster.toString());

        jedisClusterCli.set("hehe","呵呵",20);

        System.out.println(jedisClusterCli.get("hehe"));

        return "redisCluster2";
    }*/


}
