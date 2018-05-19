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
public class HttpClientController {

    @RequestMapping("/http")
    public String sendKafkaOrder(){

        return "success";
    }

}
