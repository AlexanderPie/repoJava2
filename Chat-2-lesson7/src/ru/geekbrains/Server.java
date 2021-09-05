package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private final Auth auth;
    private final Set<ClientHandler> loggedClients;

    public Server() {
        auth = new Auth();
        loggedClients = new HashSet<>();

        try {
            ServerSocket socket = new ServerSocket(8080);
            System.out.println("Сервер запущен");
            while (true) {
                Socket clSocket = socket.accept();
                new ClientHandler(clSocket, this);
            }
        } catch (IOException e) {
            throw new ServerException("Что-то пошло не так", e);
        }
    }

    public Auth getAuth() {
        return auth;
    }

    public void subs (ClientHandler cl){
        loggedClients.add(cl);
    }

    public void unsubs (ClientHandler cl){
        loggedClients.remove(cl);
    }

    public boolean isOcc(String name){
        Iterator<ClientHandler> it = loggedClients.iterator();
        while (it.hasNext()){
            ClientHandler client = it.next();
            if (client.getName() == name){
                return true;
            }
        }
        return false;
    }

    public void broadcast(String msg){
        for (ClientHandler clientHandler : loggedClients){
            clientHandler.send(msg);
        }
    }
}
