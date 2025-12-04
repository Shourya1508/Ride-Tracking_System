package com.example.ride.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ride.Config.InternalFeignSslConfig;


@FeignClient(name = "user-service", url = "https://user-service:8080",configuration = InternalFeignSslConfig.class) // replace with your user-service port
public interface UserServiceClient {

    @GetMapping("/users/{id}")
    UserResponse getUserById(@PathVariable("id") Long userId);

    class UserResponse {
        private Long id;
        private String name;
        private String email;
        private String phone;
        
        // getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
    }
}

