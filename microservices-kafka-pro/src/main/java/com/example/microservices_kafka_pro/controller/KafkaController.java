package com.example.microservices_kafka_pro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate;

    @PostMapping()
    public String reverse(@RequestParam String message){
        kafkaTemplate.send("reqbox" , message);
        return "";
    }
}
