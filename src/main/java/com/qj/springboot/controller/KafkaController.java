package com.qj.springboot.controller;

import com.qj.springboot.bean.Order;
import com.qj.springboot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/sendString")
    public String sendSting(){
        kafkaProducer.sendStirng("i am produce :" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "kafka";
    }

    @RequestMapping("/sendBean")
    public String sendBean(){
        Order order = new Order();
        order.setFid(Long.valueOf(1));
        order.setFtype(1);
        order.setFfx(new BigDecimal(0.6));
        order.setFcoinid(20);
        order.setFaccountcoinid(10);
        order.setFprice(new BigDecimal(90));
        order.setFquantity(new BigDecimal(20));
        order.setFcreatetime(System.currentTimeMillis());
        kafkaProducer.sendBean(order);
        return "kafka";
    }

}
