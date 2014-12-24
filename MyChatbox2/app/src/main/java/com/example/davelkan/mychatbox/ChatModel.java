package com.example.davelkan.mychatbox;

/**
 * Created by davelkan on 12/22/14
 */
public class ChatModel{
    // class to contain chat message information
    public String name, message;
    public long timestamp;

    public ChatModel(){}

    public ChatModel(String sender, String message){
        // constructor to assign values
        this.name = sender;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public ChatModel(String sender, String message, long timestamp) {
        // constructor to assign values
        this.name = sender;
        this.message = message;
        this.timestamp = timestamp;
    }
}