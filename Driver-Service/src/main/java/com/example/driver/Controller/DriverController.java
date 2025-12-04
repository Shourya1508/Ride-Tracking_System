package com.example.driver.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.driver.Entity.Driver;
import com.example.driver.KafkaEventPublisher.DriverLocationPublisher;
import com.example.driver.Service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverLocationPublisher locationPublisher;

    @PostMapping("/register")
    public Driver register(@RequestBody Driver driver) {
        return driverService.register(driver);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping("/{id}/location")
    public Driver updateLocation(@PathVariable Long id, @RequestParam Double lat, @RequestParam Double lon) {
        Driver driver = driverService.updateLocation(id, lat, lon);
        String message = driver.getId() + ":" + driver.getLatitude() + ":" + driver.getLongitude();
        locationPublisher.publishLocation(driver);
        System.out.println("📢 Kafka Published: " + message);
        return driver;
    }
}

