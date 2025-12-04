package com.example.notification.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl ms = new JavaMailSenderImpl();

        ms.setHost("smtp.gmail.com");
        ms.setPort(587);
        ms.setUsername("0201cs191104@gmail.com");
        ms.setPassword("pcdl xyas qzrc xzsf");  // NOT normal Gmail password

        Properties props = ms.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");

        return ms;
    }
}

