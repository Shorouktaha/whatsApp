package com.example.whatsapp.model;

public class chatmodel {
    private String username;
    private int photo;
    private String chat;
    public chatmodel(String username, int photo, String chat){
        this.chat=chat;
        this.photo=photo;
        this.username=username;
    }
    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
