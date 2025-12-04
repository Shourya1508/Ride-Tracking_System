package com.example.driver.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ORSRouteResponse {

    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    // ---------------------- INNER CLASSES -----------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Feature {
        private Properties properties;
        private Geometry geometry;

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Properties {
        private List<Segment> segments;

        public List<Segment> getSegments() {
            return segments;
        }

        public void setSegments(List<Segment> segments) {
            this.segments = segments;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Segment {
        private double distance;
        private double duration;
        private List<Step> steps;

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public List<Step> getSteps() {
            return steps;
        }

        public void setSteps(List<Step> steps) {
            this.steps = steps;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Step {
        private String instruction;
        private double distance;
        private double duration;

        public String getInstruction() {
            return instruction;
        }

        public void setInstruction(String instruction) {
            this.instruction = instruction;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {
        private List<List<Double>> coordinates;

        public List<List<Double>> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<List<Double>> coordinates) {
            this.coordinates = coordinates;
        }
    }
}



