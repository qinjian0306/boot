package com.qj.springboot.kafka;

import com.qj.springboot.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送String类型消息到kafka
     */
    public void sendStirng(String msg){
        System.out.println("produce send : " + msg);
        kafkaTemplate.send("msg",msg);
    }

    /**
     * 发送自定义Bean类型消息到kafka
     */
    public void sendBean(Order order){
        System.out.println("produce send : " + order.toString());
        kafkaTemplate.send("order", order);
    }

}
