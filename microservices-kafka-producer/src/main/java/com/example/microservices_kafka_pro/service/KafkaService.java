package com.example.microservices_kafka_pro.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(topics = "ansbox" ,groupId = "hell")
    public String run(String answer){
        System.out.println(answer);
        return answer;
    }
}
