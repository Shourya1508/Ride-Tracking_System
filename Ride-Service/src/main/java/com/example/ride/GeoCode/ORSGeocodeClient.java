package com.example.ride.GeoCode;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ride.Config.FeignSSLIgnoreConfig;
import com.example.ride.Entity.ORSGeocodeResponse;

@FeignClient(name = "ors-geocode", url = "https://api.openrouteservice.org",configuration=FeignSSLIgnoreConfig.class)
public interface ORSGeocodeClient {

    @GetMapping("/geocode/search")
    ORSGeocodeResponse search(
        @RequestParam("api_key") String apiKey,
        @RequestParam("text") String text,
        @RequestParam(value = "size", required = false) Integer size
    );
}

