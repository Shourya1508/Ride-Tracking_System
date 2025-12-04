package com.example.event.model;

public class UserEvent {

    private String userId;
    private String action;

    public UserEvent() {}

    public UserEvent(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "UserEvent{userId='" + userId + "', action='" + action + "'}";
    }
}

