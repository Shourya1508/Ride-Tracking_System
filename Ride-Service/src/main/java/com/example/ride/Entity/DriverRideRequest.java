package com.example.ride.Entity;

public class DriverRideRequest {
    private Long rideId;
    private Long driverId; // assigned driver, could be null if you want driver selection later
    private Double pickupLat;
    private Double pickupLon;
    private Double dropLat;
    private Double dropLon;
    
    
    public DriverRideRequest(){
    	
    }
	public Long getRideId() {
		return rideId;
	}
	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public Double getPickupLat() {
		return pickupLat;
	}
	public void setPickupLat(Double pickupLat) {
		this.pickupLat = pickupLat;
	}
	public Double getPickupLon() {
		return pickupLon;
	}
	public void setPickupLon(Double pickupLon) {
		this.pickupLon = pickupLon;
	}
	public Double getDropLat() {
		return dropLat;
	}
	public void setDropLat(Double dropLat) {
		this.dropLat = dropLat;
	}
	public Double getDropLon() {
		return dropLon;
	}
	public void setDropLon(Double dropLon) {
		this.dropLon = dropLon;
	}

    
    // getters / setters
    // default constructor
}
