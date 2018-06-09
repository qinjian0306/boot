package com.qj.springboot.redis.pubsub;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

/**
 * Subscriber
 */
@Component
public class PubSubListener extends JedisPubSub{

    /**
     * 监听到订阅频道接受到消息时的回调
     * @param channel
     * @param message
     */
    @Override
    public void onMessage(String channel, String message) {

        System.out.println("  <<< 订阅(SUBSCRIBE)< Channel:" + channel + " >接收到的Message:" + message );
        //当接收到的message为quit时，取消订阅(被动方式)
        if(message.equalsIgnoreCase("quit")){
            this.unsubscribe(channel);
        }
    }

    /**
     * 监听到订阅模式接受到消息时的回调
     * @param pattern
     * @param channel
     * @param message
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        // TODO Auto-generated method stub
    }

    /**
     * 订阅频道时的回调
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
    }

    /**
     * 取消订阅频道时的回调
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
    }

    /**
     * 取消订阅模式时的回调
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
    }

    /**
     * 订阅频道模式时的回调
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
    }



}
