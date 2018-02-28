package com.pura.model;

/**
 * Created by Manish-Pc on 17/02/2018.
 */

public class Notification {
    private String id;

    private String userId;

    private String receiverId;

    private String message;


    private String createdTime;


    public Notification() {
    }

    public Notification(String id, String userId, String receiverId, String message, String createdTime) {
        this.id = id;
        this.userId = userId;
        this.receiverId = receiverId;
        this.message = message;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
