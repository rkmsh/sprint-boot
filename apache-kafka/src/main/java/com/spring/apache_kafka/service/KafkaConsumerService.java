package com.spring.apache_kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "secret-topic", groupId = "secret-consumer-id")
    public void listen(String message) {
        System.out.println("Received message from topic: secret-topic - message: " + message);
    }
    
}
