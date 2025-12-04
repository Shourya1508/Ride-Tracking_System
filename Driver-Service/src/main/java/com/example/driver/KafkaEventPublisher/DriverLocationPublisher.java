package com.example.driver.KafkaEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.driver.Entity.Driver;

@Service
public class DriverLocationPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "driver-location";

    public void publishLocation(Driver driver) {
        String message = driver.getId() + ":" + driver.getLatitude() + ":" + driver.getLongitude();
        kafkaTemplate.send(TOPIC, message);
    }
}

