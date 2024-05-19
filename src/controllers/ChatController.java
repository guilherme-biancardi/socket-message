/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import enums.MessageType;
import enums.PageEnum;
import aps.Pages;
import forms.ChatFormInterface;
import server.ServerMessage;
import aps.User;
import exceptions.ServerErrorException;
import java.io.IOException;

/**
 *
 * @author guilh
 */
public class ChatController {
    private final ServerMessage server;

    public ChatController(User user, ChatFormInterface chat) throws IOException {
        this.server = new ServerMessage(user, chat);
    }
    
    public void disconnect() throws ServerErrorException{
        try {
            Pages.removePage(PageEnum.CHAT);
            server.disconnect();
        } catch (IOException ex) {
            throw new ServerErrorException("Não foi possível desconectar do servidor");
        }
    }
    
    public void sendMessage(String message){
       server.sendMessage(message, MessageType.MESSAGE);
    }
}
