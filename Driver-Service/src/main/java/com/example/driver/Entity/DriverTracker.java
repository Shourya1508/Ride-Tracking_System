package com.example.driver.Entity;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class DriverTracker {

    private List<List<Double>> route;
    private int pointer = 0;
    private ScheduledExecutorService scheduler;

    public List<List<Double>> getRoute() {
        return route;
    }

    public void setRoute(List<List<Double>> route) {
        this.route = route;
    }

    public int getPointer() {
        return pointer;
    }

    public void incrementPointer() {
        this.pointer++;
    }

    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }

    public void setScheduler(ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
    }
}

