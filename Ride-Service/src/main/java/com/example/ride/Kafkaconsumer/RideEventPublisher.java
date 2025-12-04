package com.example.ride.Kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RideEventPublisher {

    private static final String TOPIC = "ride-created";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void publish(Object event) {
        try {
            String json = mapper.writeValueAsString(event);
            kafkaTemplate.send(TOPIC, json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
