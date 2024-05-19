/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import aps.Message;
import enums.MessageType;
import aps.User;
import forms.ChatFormInterface;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class ServerMessage {

    private final Socket client;
    private final User user;
    private final Thread messageThread;

    public ServerMessage(User user, ChatFormInterface chat) throws IOException {
        this.client = new Socket(ServerOptions.getHOST(), ServerOptions.getPort());
        this.user = user;
        this.messageThread = new Thread(new MessageReceiver(client, chat, user));

        onConect();
    }

    private void onConect() throws IOException {
        sendMessage(user.getName() + " entrou na conversa", MessageType.NOTIFICATION);
        messageThread.start();
    }


    public void sendMessage(String message, MessageType type) {
        Message messageObject = new Message(message, user, type);

        try {
            // Cria o fluxo de saída para enviar dados para o servidor
            ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());

            // Envia os dados para o servidor
            outputStream.writeObject(messageObject);
            outputStream.flush();

        } catch (IOException ex) {
            Logger.getLogger(ServerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() throws IOException{
        sendMessage(user.getName() + " saiu da conversa", MessageType.DISCONNECTION);
    }

    public Socket getClient() {
        return client;
    }

}
