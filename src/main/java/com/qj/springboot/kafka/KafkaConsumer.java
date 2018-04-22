package com.qj.springboot.kafka;

import com.qj.springboot.bean.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    /**
     * 接收String类型参数
     * @param msg
     */
    @KafkaListener(topics={"msg"})
    public void getString(String msg) {
        System.out.println("consumer msg :" + msg);
    }

    /**
     * 接收Bean类型参数
     * @param order
     */
    @KafkaListener(topics={"order"})
    public void getBean(Order order) {
        System.out.println("consumer bean :" + order.toString());
    }

}
