package com.example.ride.Entity;

import jakarta.persistence.*;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long driverId;
    private Long userId;
    private String pickupLocation;
    private String dropLocation;
    private String status;

    public Ride() {}

    public Long getId() { return id; }
    public Long getDriverId() { return driverId; }
    public Long getUserId() { return userId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }
    public void setStatus(String status) { this.status = status; }
}

