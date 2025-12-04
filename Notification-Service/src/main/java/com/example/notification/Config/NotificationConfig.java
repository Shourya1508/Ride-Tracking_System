package com.example.notification.Config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import 
org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    public static final String EXCHANGE = "notification.exchange";
    public static final String ROUTING_KEY = "notify";
    public static final String QUEUE = "notification.queue";

    @Bean
    public TopicExchange notificationExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding notificationBinding() {
        return BindingBuilder.bind(notificationQueue())
                .to(notificationExchange())
                .with(ROUTING_KEY);
    }
}

