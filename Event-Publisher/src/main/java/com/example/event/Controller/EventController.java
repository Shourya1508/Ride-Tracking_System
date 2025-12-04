package com.example.event.Controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.event.model.UserEvent;

@RestController
public class EventController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendEvent(@RequestBody UserEvent event) {
        kafkaTemplate.send("user-events", event);
        return "Event sent to Kafka";
    }
}

