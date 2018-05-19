package com.qj.springboot.kafka;

import com.qj.springboot.kafka.model.KafkaOrder;
import com.qj.springboot.kafka.model.KafkaTrade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * send and receive
 */

@Named
public class KafkaInstant {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(KafkaInstant.class);

    @Inject
    private KafkaTemplate<String, String> stringKafkaTemplate;
    @Inject
    private KafkaTemplate<String, Object> objectKafkaTemplate;
    @Inject
    private KafkaTemplate<String, KafkaOrder> orderKafkaTemplate;
    @Inject
    private KafkaTemplate<String, KafkaTrade> tradeKafkaTemplate;

    // producer
    @Value("${spring.kafka.topic.orderTopic}")
    private String orderTopic;
    @Value("${spring.kafka.topic.tradeTopic}")
    private String tradeTopic;

    public void sendOrder(KafkaOrder order) {
        orderKafkaTemplate.send(orderTopic, order);
        System.out.println("produce order : " + order.toString());
    }

    public void sendTrade(KafkaTrade trade) {
        tradeKafkaTemplate.send(tradeTopic, trade);
        System.out.println("produce order : " + trade.toString());
    }


    // consumer1 queue
    @KafkaListener(topics = {"${spring.kafka.topic.orderTopic}"}, containerFactory = "kafkaOrderListenerContainerFactory")
    public void processTrades1(KafkaOrder order) throws Exception {

        System.out.println("queue ip1111 consume1 trade : " + order.toString());

    }

    // consumer2 topic
    @KafkaListener(topics = {"${spring.kafka.topic.tradeTopic}"}, containerFactory = "kafkaTradeListenerContainerFactory")
    public void processTrades2(KafkaTrade trade) throws Exception {

        System.out.println("topic ip1111 consume2 trade : " + trade.toString());

    }

}