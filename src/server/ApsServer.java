/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import aps.Message;
import enums.MessageType;
import aps.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class ApsServer {

    private static final ArrayList<Socket> CLIENTS = new ArrayList<>();
    private static final ArrayList<Integer> USERS_ID = new ArrayList<>();

    public synchronized static void sendAllClients(Message message) throws IOException {
        for (Socket item : CLIENTS) {
            // Envia a classe Dados para o cliente
            ObjectOutputStream outputStream = new ObjectOutputStream(item.getOutputStream());
            outputStream.writeObject(message);
            outputStream.flush();
        }
    }

    public synchronized static void removeByPort(int port) throws IOException {
        Iterator<Socket> iterator = CLIENTS.iterator();

        while (iterator.hasNext()) {
            Socket item = iterator.next();
            if (item.getPort() == port) {
                iterator.remove();
                item.close();
                
                System.out.println("Cliente desconectado");
            }
        }
    }

    public synchronized static void removeUserId(int id) throws IOException {
        Iterator<Integer> iterator = USERS_ID.iterator();

        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item == id) {
                iterator.remove();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;
        private boolean isNotConected = true;

        public ClientHandler(Socket socket) {
            this.socket = socket;

            System.out.println("Novo cliente conectado");

        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Cria o fluxo de entrada para receber dados do cliente
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                    // Recebe os dados enviados pelo cliente
                    Message data = (Message) inputStream.readObject();

                    User user = data.getUser();

                    if (isNotConected) {
                        if (USERS_ID.contains(user.getId())) {
                            Message message = new Message("usuário já conectado", user, MessageType.USER_IS_CONNECTED);

                            // Envia a classe Dados para o cliente
                            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                            outputStream.writeObject(message);
                            outputStream.flush();
                        } else {
                            USERS_ID.add(user.getId());
                            CLIENTS.add(socket);
                            isNotConected = false;
                        }
                    }

                    switch (data.getType()) {
                        case MESSAGE -> {
                            // Obtém a data e hora atual
                            Date currentDate = new Date();

                            // Define o formato desejado
                            SimpleDateFormat dateFormat = new SimpleDateFormat("'enviado por " + user.getName() + " às' HH:mm");

                            // Formata a data e hora atual
                            data.setMessageDate(dateFormat.format(currentDate));
                        }

                        case DISCONNECTION -> {
                            removeUserId(user.getId());
                        }
                    }

                    sendAllClients(data);

                    if (data.getType() == MessageType.DISCONNECTION || data.getType() == MessageType.USER_IS_CONNECTED) {
                        removeByPort(socket.getPort());

                        break;
                    }

                }

            } catch (IOException e) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ApsServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // Cria um ServerSocket na porta especificada
            ServerSocket server = new ServerSocket(ServerOptions.getPort());
            System.out.println("Servidor aguardando conexão...");

            while (true) {
                // Aceita a conexão do cliente
                Socket socket = server.accept();

                // Cria uma nova thread para lidar com a conexão do cliente
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ApsServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
