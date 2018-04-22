package com.qj.springboot.websocket;

import com.qj.springboot.service.UserTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * websocket
 */
@ServerEndpoint(value = "/webSocket/{userId}")
@Component
public class MyWebSocket {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    private UserTestService userTestService;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {

        userTestService = (UserTestService)applicationContext.getBean(UserTestService.class);

        System.out.println("建立连接 : userId = "+ userId);
        MyWebSocketUtils.add(userId , session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("userId") String userId,Session session) {
        System.out.println("断开连接 : userId = " + userId);
        MyWebSocketUtils.remove(userId);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(@PathParam("userId") String userId, String message) {
        System.out.println("接收到消息 : userId = "+ userId + " , message = " + message);
        MyWebSocketUtils.receive(userId , message);
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(@PathParam("userId") String userId,Session session,Throwable error) {
        System.out.println("连接出错 : userId = "+ userId + " , throwable = " + error.getMessage());
        MyWebSocketUtils.remove(userId);
    }

}
