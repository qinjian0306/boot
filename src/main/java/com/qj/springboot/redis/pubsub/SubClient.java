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
public class SubClient extends Thread{

    @Autowired
    private JedisCli jedisCli;

    private String channel;
    private JedisPubSub jedisPubSub;

    public void setChannelAndPubsub(JedisPubSub jedisPubSub,String channel){

        this.jedisPubSub=jedisPubSub;
        this.channel=channel;
    }

    /**
     * 接受消息
     */
    public void subscribe(){

        Jedis jedis = null;

        try{
            jedis = jedisCli.getJedisPool().getResource();
            jedis.subscribe(jedisPubSub, channel);
        }catch(Exception e){
            System.out.println(e);
        }
    }


    @Override
    public void run() {
        this.subscribe();
    }

}
