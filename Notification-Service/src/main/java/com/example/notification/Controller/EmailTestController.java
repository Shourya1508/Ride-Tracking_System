package com.example.notification.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.notification.Service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendTestMail(@RequestParam String to) {
        emailService.sendEmail(to, "Test Email", "This is a test email!");
        return "Email sent";
    }
}

