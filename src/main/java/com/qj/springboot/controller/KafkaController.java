package com.qj.springboot.controller;

import com.qj.springboot.kafka.KafkaInstant;
import com.qj.springboot.kafka.model.KafkaOrder;
import com.qj.springboot.kafka.model.KafkaTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka controller
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaInstant kafkaInstant;

    @RequestMapping("/queue")
    public String queue(){
        KafkaOrder kafkaOrder = new KafkaOrder();
        kafkaOrder.setCryptoCode("BTC");
        kafkaOrder.setExpireTime(System.currentTimeMillis());
        kafkaOrder.setCreateTime(System.currentTimeMillis());
        kafkaInstant.sendOrder(kafkaOrder);
        return "success";
    }

    @RequestMapping("/topic")
    public String topic(){
        KafkaTrade kafkaTrade = new KafkaTrade();
        kafkaTrade.setOrderId(Long.valueOf(10086));
        kafkaTrade.setTime(System.currentTimeMillis());
        kafkaInstant.sendTrade(kafkaTrade);
        return "success";
    }

}
