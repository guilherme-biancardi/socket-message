/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aps;

import enums.MessageType;
import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class Message implements Serializable{
    private final String message;
    private final User user;
    private String messageDate;
    private final MessageType type;

    public Message(String message, User user, MessageType type) {
        this.message = message;
        this.user = user;
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageDate() {
        return messageDate;
    }
    
    public String getMessage() {
        return message;
    }
    
    public User getUser(){
        return user;
    }
}
