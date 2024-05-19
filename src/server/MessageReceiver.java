/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import aps.Message;
import enums.MessageType;
import enums.PageEnum;
import aps.Pages;
import aps.User;
import components.MessageComponent;
import components.NotificationComponent;
import forms.ChatFormInterface;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class MessageReceiver implements Runnable {

    private final Socket socket;
    private final ChatFormInterface chat;
    private final User user;

    public MessageReceiver(Socket socket, ChatFormInterface chat, User user) {
        this.socket = socket;
        this.chat = chat;
        this.user = user;
    }

    @Override
    public void run() {

        while (true) {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) inputStream.readObject();
                
                User userMessage = message.getUser();

                boolean isCurrentUserMessage = user.getId() == userMessage.getId();

                switch (message.getType()) {
                    case MESSAGE -> {
                        MessageComponent messageComponent = new MessageComponent(isCurrentUserMessage, message.getMessage(), message.getMessageDate());

                        chat.rendererMessage(messageComponent);
                    }
                    case NOTIFICATION, DISCONNECTION -> {
                        if (!isCurrentUserMessage) {
                            NotificationComponent component = new NotificationComponent(message.getMessage());
                            chat.rendererMessage(component);
                        }
                    }
                    
                    case USER_IS_CONNECTED -> {
                        chat.closeOnError(message.getMessage());
                        Pages.redirect(PageEnum.LOGIN, null);
                    }
                }
                
                if (message.getType() == MessageType.USER_IS_CONNECTED) {
                    break;
                }

                if (message.getType() == MessageType.DISCONNECTION && isCurrentUserMessage) {
                    break;
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
