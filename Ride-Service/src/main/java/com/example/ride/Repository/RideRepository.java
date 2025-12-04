package com.example.ride.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ride.Entity.Ride;


public interface RideRepository extends JpaRepository<Ride, Long> {
}
