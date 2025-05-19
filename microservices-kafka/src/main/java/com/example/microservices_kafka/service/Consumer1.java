package com.example.microservices_kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer1 {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "reqbox", groupId = "hell")
    public void reverseAndSend(String str) {
        System.out.println("Called !");
        if (str == null) {
            System.err.println("Received null message");
            return;
        }

        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        String reversed = new String(chars);

        kafkaTemplate.send("ansbox", reversed);
    }
}
