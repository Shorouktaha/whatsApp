package com.example.whatsapp.model;

public class messageModel {
    private String message,senderId;
public messageModel(){

}
    public messageModel(String message, String senderId) {
        this.message = message;
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderId() {
        return senderId;
    }
}
