package com.example.ride.Entity;


import java.util.List;

public class ORSGeocodeResponse {
    private List<Feature> features;
    public static class Feature {
        private Geometry geometry;
        public Geometry getGeometry() { return geometry; }
        public void setGeometry(Geometry g) { this.geometry = g; }
    }
    public static class Geometry {
        private List<Double> coordinates; // [lon, lat]
        public List<Double> getCoordinates() { return coordinates; }
        public void setCoordinates(List<Double> c) { this.coordinates = c; }
    }
    public List<Feature> getFeatures() { return features; }
    public void setFeatures(List<Feature> features) { this.features = features; }
}

