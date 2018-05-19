package com.qj.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;


/**
 * @Named == @Component
 * @Inject == @Autowired == @Resource
 *
 * @Named:
 *       替代@Component来声明一个Bean
 * @Inject:
 *      这是jsr330中的规范，通过‘AutowiredAnnotationBeanPostProcessor’ 类实现的依赖注入
 *
 *
 */
//@Component
@Named
public class KafkaConfig {

//    @Autowired
    @Inject
    private KafkaProperties properties;

    @Bean
    public Map<String, Object> kafkaConsumerQueueConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServer());
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getQueueGroupId());// queue
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        //configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaProperties.CONSUMER_MODE);
        return configProps;
    }

    @Bean
    public Map<String, Object> kafkaConsumerTopicConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServer());
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getTopicGroupId());// topic
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        //configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaProperties.CONSUMER_MODE);
        return configProps;
    }

    @Bean
    public Map<String, Object> kafkaProducerConfig(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServer());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configProps;
    }
}

