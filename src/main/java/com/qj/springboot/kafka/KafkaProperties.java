package com.qj.springboot.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
@ConfigurationProperties("spring.kafka")
public class KafkaProperties {
    public static final String CONSUMER_MODE = "earliest";

    private String bootstrapServer;

    private String queueGroupId;

    private String topicGroupId;

    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public void setBootstrapServer(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    public String getQueueGroupId() {
        return queueGroupId;
    }

    public void setQueueGroupId(String queueGroupId) {
        this.queueGroupId = queueGroupId;
    }

    public String getTopicGroupId() {
        return topicGroupId;
    }

    public void setTopicGroupId(String topicGroupId) {
        this.topicGroupId = topicGroupId;
    }

    private final Topics topics = new Topics();

    public static class Topics{

        private String tradeTopic;
        private String orderTopic;

        public String getTradeTopic() {
            return tradeTopic;
        }

        public void setTradeTopic(String tradeTopic) {
            this.tradeTopic = tradeTopic;
        }

        public String getOrderTopic() {
            return orderTopic;
        }

        public void setOrderTopic(String orderTopic) {
            this.orderTopic = orderTopic;
        }
    }

    public Topics getTopics() {
        return topics;
    }

}
