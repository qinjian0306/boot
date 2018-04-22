package com.qj.springboot.controller;

import com.qj.springboot.kafka.KafkaInstant;
import com.qj.springboot.kafka.model.KafkaOrder;
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

    @RequestMapping("/kafka")
    public String sendKafkaOrder(){
        KafkaOrder kafkaOrder = new KafkaOrder();
        kafkaOrder.setCryptoCode("BTC");
        kafkaOrder.setExpireTime(System.currentTimeMillis());
        kafkaOrder.setCreateTime(System.currentTimeMillis());
        kafkaInstant.sendOrder(kafkaOrder);
        return "success";
    }

}
