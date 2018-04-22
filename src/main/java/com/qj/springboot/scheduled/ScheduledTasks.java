package com.qj.springboot.scheduled;


import com.qj.springboot.websocket.MyWebSocket;
import com.qj.springboot.websocket.MyWebSocketUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 定时任务
 */
@Component
@Configurable
@EnableScheduling
@EnableAsync
public class ScheduledTasks {

    @Autowired
    private MyWebSocket myWebSocket;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Map<String, Session> map =  MyWebSocketUtils.clients;
        if(map.size() > 0 ){
            try {
                for (Map.Entry<String, Session> client : map.entrySet()) {
                    String userId = client.getKey();
                    Session session = client.getValue();
                    if("333333".equals(userId)){
                        MyWebSocketUtils.sendMessage(userId,"333333333333333");
                    }
                    if("777777".equals(userId)){
                        MyWebSocketUtils.sendMessage(userId,"6666666666666666");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试多个定时任务并发执行
     */
//    @Async
//    @Scheduled(fixedRate = 2000)
//    public void startSchedule() {
//        try {
//            if (MyWebSocket.ONOPEN) {
//                for (MyWebSocket socket : MyWebSocket.wbSockets) {
//                    socket.sendMessage("第" + i + "条消息...");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Async
//    @Scheduled(fixedRate = 3000)
//    public void startSchedule2() {
//        try {
//            if (MyWebSocket.ONOPEN) {
//                for (MyWebSocket socket : MyWebSocket.wbSockets) {
//                    socket.sendMessage("第" + i + "条消息...");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}