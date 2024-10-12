package com.kafka.avro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.avro.dto.Employee;
import com.kafka.avro.producer.KafkaAvroProducer;

@RestController
public class EventController {
    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/events")
    public String sendMessage(@RequestBody Employee employee) {
        producer.send(employee);
        return "message published !";
    }
}
