package com.qj.springboot.redis.pubsub;

import com.qj.springboot.redis.single.JedisCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Subscriber
 */
@Component
public class PubClient extends Thread{

    @Autowired
    private JedisCli jedisCli;

    /**
     * 发送消息
     * @param channel 频道
     * @param message 消息体
     */
    public void publish(String channel, String message){
        Jedis jedis = null;
        try{
            jedis = jedisCli.getJedisPool().getResource();
            jedis.publish(channel, message);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
