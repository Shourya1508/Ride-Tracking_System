package com.example.ride.RabbitmqPublisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String EXCHANGE = "notification.exchange";
    private static final String ROUTING_KEY = "notify";

    public void sendRideNotification(String email, String message) {
        String payload = "email=" + email + ";body=" + message;
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, payload);
        System.out.println("📩 RabbitMQ Published: " + payload);
    }
}
