package com.example.ride.Service;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class DriverTrackingService {

    private final ConcurrentHashMap<Long, double[]> locations = new ConcurrentHashMap<>();

    public void updateLocation(Long driverId, Double lat, Double lon) {
        locations.put(driverId, new double[]{lat, lon});
        System.out.println("Driver " + driverId + " => " + lat + "," + lon);
    }

    public double[] getLocation(Long driverId) {
        return locations.get(driverId);
    }
}

