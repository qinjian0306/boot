package com.qj.springboot.websocket;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * utils
 */
public class MyWebSocketUtils {

    //客户端集合 存放客户端的用户id和session
    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    /**
     * 建立客户端连接 添加用户id和session
     */
    public static void add(String userId, Session session) {
        clients.put(userId,session);
        System.out.println(("当前连接数 = " + clients.size()));

    }

    /**
     * 移除客户端连接 用户id和session
     * @param userId
     */
    public static void remove(String userId) {
        clients.remove(userId);
        System.out.println(("当前连接数 = " + clients.size()));
    }

    /**
     * 接收客户端的消息
     * @param userId
     * @param message
     */
    public static void receive(String userId, String message) {
        System.out.println("收到消息 : UserId = " + userId + " , Message = " + message);
        System.out.println(("当前连接数 = " + clients.size()));
    }

    /**
     * 发送消息到对应的客户端
     * @param userId
     * @param message
     * @return
     */
    public static boolean sendMessage(String userId , String message) {
        System.out.println(("当前连接数 = " + clients.size()));
        if(clients.get(userId) == null){
            return false;
        }else{
            clients.get(userId).getAsyncRemote().sendText(message);
            return true;
        }
    }


}
