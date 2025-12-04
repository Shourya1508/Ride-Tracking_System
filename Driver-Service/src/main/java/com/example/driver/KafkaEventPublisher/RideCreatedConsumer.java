package com.example.driver.KafkaEventPublisher;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.driver.Entity.DriverRideRequest;
import com.example.driver.Service.DriverService;

@Service
public class RideCreatedConsumer {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private DriverService driverService;

    @KafkaListener(topics = "ride-created", groupId = "driver-service-group")
    public void onMessage(String message) {
        try {
            DriverRideRequest req = mapper.readValue(message, DriverRideRequest.class);
            // Start route preparation & simulation for this driver
            driverService.prepareRouteAndStart(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

