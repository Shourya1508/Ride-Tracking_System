package com.example.driver.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.driver.Config.InternalFeignSslConfig;

@FeignClient(name = "ride-service", url = "https://ride-service:8082", configuration = InternalFeignSslConfig.class)
public interface RideServiceClient {

    @PostMapping("/rides/driver/{driverId}/location")
    void sendLocation(
            @PathVariable Long driverId,
            @RequestParam Double lat,
            @RequestParam Double lon
    );
}


